package com.orcchg.sample.atscale.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.sample.atscale.core.ui.AutoDisposeViewModel
import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.ui.convert.StockVoConverter
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import com.uber.autodispose.autoDispose
import io.reactivex.Completable
import timber.log.Timber
import javax.inject.Inject

class StockListViewModel @Inject constructor(
    private val interactor: StockListInteractor,
    private val stockVoConverter: StockVoConverter
) : AutoDisposeViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    internal val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Boolean>()
    internal val error: LiveData<Boolean> = _error

    private val _stocks by lazy(LazyThreadSafetyMode.NONE) {
        val data = MutableLiveData<List<StockVO>>()
        loadStocks(data)
        data
    }
    internal val stocks: LiveData<List<StockVO>> by lazy(LazyThreadSafetyMode.NONE) { _stocks }

    fun retryLoadStocks() {
        _stocks.value = emptyList()
        Completable.fromAction { loadStocks(_stocks) }
            .autoDispose(this)
            .subscribe({}, Timber::e)
    }

    private fun loadStocks(data: MutableLiveData<List<StockVO>>) {
        interactor.stocks()
            .doOnSubscribe {
                _loading.value = true
                _error.value = false
            }
            .doFinally { _loading.value = false }
            .map(stockVoConverter::convertList)
            .autoDispose(this)
            .subscribe(
                {
                    data.value = it
                    _error.value = false
                }, {
                    Timber.e(it)
                    _error.value = true
                }
            )
    }
}
