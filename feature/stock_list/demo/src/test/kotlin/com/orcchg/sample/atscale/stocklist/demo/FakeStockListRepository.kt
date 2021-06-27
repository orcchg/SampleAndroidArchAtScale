package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class FakeStockListRepository @Inject constructor() : StockListRepository {

    override fun stocks(): Single<List<Stock>> =
        Single.just(
            listOf(
                Stock(
                    name = "Yandex, LLC",
                    ticker = "YNDX",
                    price = 4764.6.money()
                ),
                Stock(
                    name = "Apple Inc.",
                    ticker = "AAPL",
                    price = 131.93.money()
                ),
                Stock(
                    name = "Alphabet Class A",
                    ticker = "GOOGL",
                    price = 1825.0.money()
                ),
                Stock(
                    name = "Amazon.com",
                    ticker = "AMZN",
                    price = 3204.6.money()
                ),
                Stock(
                    name = "Bank of America Corp",
                    ticker = "BAC",
                    price = 24.7.money()
                ),
                Stock(
                    name = "Microsoft Corporation",
                    ticker = "MSFT",
                    price = 234.12.money()
                ),
                Stock(
                    name = "Tesla Motors",
                    ticker = "TSLA",
                    price = 599.08.money()
                ),
                Stock(
                    name = "Mastercard",
                    ticker = "MA",
                    price = 519.21.money()
                ),
                Stock(
                    name = "Appfolio Inc.",
                    ticker = "APPF",
                    price = 330.33.money()
                ),
                Stock(
                    name = "Appian Corp.",
                    ticker = "APPN",
                    price = 271.09.money()
                ),
                Stock(
                    name = "Appi Inc.",
                    ticker = "APPI",
                    price = 17.18.money()
                )
            )
        )

    override fun stock(ticker: String): Maybe<Stock> =
        Maybe.just(
            Stock(
                name = "Fake Stock",
                ticker = ticker,
                price = 250.51.money()
            )
        )
}