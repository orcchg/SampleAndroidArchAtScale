package com.orcchg.sample.atscale.stockdetails.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.sample.atscale.core.ui.AutoDisposeViewModel
import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import com.orcchg.sample.atscale.stockdetails.api.di.Ticker
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class StockDetailsViewModel @Inject constructor(
    @Ticker private val ticker: String,
    private val interactor: StockDetailsInteractor,
    private val stockListInteractor: StockListInteractor
) : AutoDisposeViewModel() {

    private val _candles by lazy(LazyThreadSafetyMode.NONE) {
        val data = MutableLiveData<List<Candle>>()
        candlesInternal(data, Candle.Resolution.Day, 0L, System.currentTimeMillis())
        data
    }
    internal val candles: LiveData<List<Candle>> = _candles

    private val _stock by lazy(LazyThreadSafetyMode.NONE) {
        val data = MutableLiveData<Stock>()
        stockListInteractor.stock(ticker)
            .autoDispose(this)
            .subscribe({ data.value = it }, Timber::e)
        data
    }
    internal val stock: LiveData<Stock> = _stock

    private fun candlesInternal(
        data: MutableLiveData<List<Candle>>,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ) {
        interactor.candles(
            ticker = ticker,
            resolution = resolution,
            fromTs = fromTs,
            toTs = toTs
        )
            .autoDispose(this)
            .subscribe({ data.value = it }, Timber::e)
    }
}
