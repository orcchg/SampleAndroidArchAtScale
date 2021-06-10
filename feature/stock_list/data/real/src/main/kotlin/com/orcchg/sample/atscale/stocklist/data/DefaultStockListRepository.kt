package com.orcchg.sample.atscale.stocklist.data

import android.text.format.DateUtils
import com.orcchg.sample.atscale.stocklist.domain.Issuer
import com.orcchg.sample.atscale.stocklist.domain.Quote
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import com.orcchg.sample.atscale.stocklist.data.local.IssuerDao
import com.orcchg.sample.atscale.stocklist.data.local.QuoteDao
import com.orcchg.sample.atscale.stocklist.data.local.convert.IssuerDboConverter
import com.orcchg.sample.atscale.stocklist.data.local.convert.QuoteDboConverter
import com.orcchg.sample.atscale.stocklist.data.remote.StockListRest
import com.orcchg.sample.atscale.stocklist.data.remote.convert.IssuerNetworkToDboConverter
import com.orcchg.sample.atscale.stocklist.data.remote.convert.QuoteNetworkConverter
import com.orcchg.sample.atscale.util.toSet
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DefaultStockListRepository @Inject constructor(
    private val restCloud: StockListRest,
    private val localIssuer: IssuerDao,
    private val localQuote: QuoteDao,
    private val issuerLocalConverter: IssuerDboConverter,
    private val issuerNetworkToLocalConverter: IssuerNetworkToDboConverter,
    private val quoteLocalConverter: QuoteDboConverter,
    private val quoteNetworkConverter: QuoteNetworkConverter
) : StockListRepository {

    override fun stocks(): Single<List<Stock>> =
        issuers()
            .flatMapObservable {
                Observable.fromIterable(it)
                    .concatMapSingle { issuer ->
                        quote(issuer.ticker)
                            .map { quote ->
                                Stock(
                                    ticker = issuer.ticker,
                                    name = issuer.name,
                                    price = quote.currentPrice,
                                    priceDailyChange = quote.priceDayChange,
                                    logoUrl = issuer.logoUrl
                                )
                            }
                    }
            }
            .toList()

    private fun issuers(): Single<List<Issuer>> =
        index() // load full index and retain only those issuers missing in local cache
            .retainOnlyIssuersMissingInCache()
            .flatMapCompletable { tickers ->
                if (tickers.isEmpty()) {
                    // either all issuers from index are already cached, or there is no issuers at all
                    Completable.complete() // get issuers from local cache
                } else {
                    // found new issuers in index that haven't been cached yet, fetch them from network
                    // limit by 'API_REQUEST_LIMIT' requests per second to avoid HTTP 429 from Finnhub
                    val chunks = tickers.chunked(API_REQUEST_LIMIT)

                    Observable.fromIterable(chunks).take(2) // fetch 2 chunks at a time
                        .zipWith(Observable.range(0, chunks.size)) { c, i -> c to i }
                        .concatMap { (c, i) ->
                            Observable.just(c).delay(if (i > 0) 1000L else 0L, TimeUnit.MILLISECONDS, Schedulers.trampoline())
                        }
                        .concatMapCompletable { chunk ->
                            Observable.fromIterable(chunk)
                                .flatMapSingle(restCloud::issuer)
                                .map(issuerNetworkToLocalConverter::convert)
                                .toList() // chunk of issuers has been loaded
                                .flatMapCompletable { issuers -> // cache loaded issuers
                                    Completable.fromAction { localIssuer.addIssuers(issuers) }
                                }
                        }
                }
            }
            .toSingleDefault(0L)
            // cache is up to date now, get issuer from it as a single source of truth
            .flatMap { localIssuers() }

    private fun localIssuers(): Single<List<Issuer>> =
        localIssuer.issuers().map(issuerLocalConverter::convertList)

    private fun quote(ticker: String): Single<Quote> =
        quoteNetwork(ticker).toObservable()
            // let network and local sources to compete which will emit faster and take the winner one
            .publish { network -> Observable.merge(network, quoteLocal(ticker).toObservable().takeUntil(network)) }
            .first(Quote(ticker)) // take one who emits first (either network or local)

    private fun quoteLocal(ticker: String): Maybe<Quote> =
        localQuote.quote(ticker)
            // cached quote is considered stale if it has been cached more that a day ago
            .filter { System.currentTimeMillis() - it.timestamp < DateUtils.DAY_IN_MILLIS }
            .map(quoteLocalConverter::convert)

    private fun quoteNetwork(ticker: String): Single<Quote> =
        restCloud.quote(ticker)
            .map { quoteNetworkConverter.convert(ticker, it) }
            .flatMap { quote ->
                // quote database object will be created from quote domain object
                // at the current timestamp, which will be used as an age of quote entry in cache
                Completable.fromAction { localQuote.addQuote(quoteLocalConverter.revert(quote)) }
                    .toSingleDefault(quote)
            }

    /**
     * Finnhub Open API allows to fetch popular index, such as S&P500 or NASDAQ,
     * but for simplicity we rely on predefined list of tickers.
     */
    private fun index(): Single<Collection<String>> =
        Single.just(
            listOf("AAPL", "MRNA", "NFLX", "GOOGL", "TSLA", "T", "FB", "MSFT", "AMZN")
        )

    private fun Single<Collection<String>>.retainOnlyIssuersMissingInCache(): Single<Collection<String>> =
        flatMap { tickers ->
            Observable.fromIterable(tickers)
                .filter(localIssuer::noIssuer)
                .toSet()
        }

    companion object {
        const val API_REQUEST_LIMIT = 30
    }
}