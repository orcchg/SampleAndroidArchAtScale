package com.orcchg.sample.atscale.stocklist.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.sample.atscale.core.uicorelib.AutoDisposeViewModel
import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.ui.convert.StockVoConverter
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

internal class StockListViewModel @Inject constructor(
    private val interactor: StockListInteractor,
    private val stockVoConverter: StockVoConverter
) : AutoDisposeViewModel() {

    private val _stocks by lazy(LazyThreadSafetyMode.NONE) {
        val data = MutableLiveData<List<StockVO>>()
        interactor.stocks()
            .map(stockVoConverter::convertList)
            .autoDispose(this)
            .subscribe({ data.value = it }, Timber::e)
        data
    }
    internal val stocks: LiveData<List<StockVO>> by lazy(LazyThreadSafetyMode.NONE) { _stocks }
}
