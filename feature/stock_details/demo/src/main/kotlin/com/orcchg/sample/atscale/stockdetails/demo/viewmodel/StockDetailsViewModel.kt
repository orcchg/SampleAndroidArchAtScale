package com.orcchg.sample.atscale.stockdetails.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.sample.atscale.core.ui.AutoDisposeViewModel
import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import com.orcchg.sample.atscale.stockdetails.api.di.Ticker
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

internal class StockDetailsViewModel @Inject constructor(
    @Ticker private val ticker: String,
    private val interactor: StockDetailsInteractor
) : AutoDisposeViewModel() {

    private val _candles by lazy(LazyThreadSafetyMode.NONE) {
        val data = MutableLiveData<List<Candle>>()
        interactor.candles(ticker, Candle.Resolution.Day, 0L, System.currentTimeMillis())
            .autoDispose(this)
            .subscribe({ data.value = it}, Timber::e)
        data
    }
    internal val candles: LiveData<List<Candle>> = _candles
}
