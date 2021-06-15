package com.orcchg.sample.atscale.main.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.sample.atscale.androidutil.clickThrottle
import com.orcchg.sample.atscale.androidutil.observe
import com.orcchg.sample.atscale.androidutil.viewBindings
import com.orcchg.sample.atscale.core.ui.BaseFragment
import com.orcchg.sample.atscale.di.getFeature
import com.orcchg.sample.atscale.main.di.DaggerStockListFragmentComponent
import com.orcchg.sample.atscale.main.ui.databinding.MainStockListFragmentBinding
import com.orcchg.sample.atscale.main.viewmodel.StockListViewModel
import com.orcchg.sample.atscale.main.viewmodel.StockListViewModelFactory
import com.orcchg.sample.atscale.stocklist.ui.adapter.StockListAdapter
import javax.inject.Inject

class StockListFragment : BaseFragment(R.layout.main_stock_list_fragment) {

    @Inject lateinit var stockListAdapter: StockListAdapter
    @Inject lateinit var factory: StockListViewModelFactory
    private val binding by viewBindings(MainStockListFragmentBinding::bind)
    private val viewModel by viewModels<StockListViewModel> { factory }

    @Suppress("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerStockListFragmentComponent.factory()
            .create(featureApi = api.getFeature())
            .inject(this)
        super.onViewCreated(view, savedInstanceState)

        stockListAdapter.itemClickListener = {
            findNavController()
                .navigate(
                    R.id.nav_action_open_stock_details,
                    Bundle().apply { putString("ticker", it.ticker) }
                )
        }

        binding.rvItems.adapter = stockListAdapter
        binding.btnError.clicks().clickThrottle().subscribe { viewModel.retryLoadStocks() }

        observe(viewModel.loading, ::showLoading)
        observe(viewModel.error, ::showError)
        observe(viewModel.stocks, stockListAdapter::update)
    }

    private fun showLoading(isShow: Boolean) {
        binding.pbLoading.isInvisible = !isShow
        binding.tvError.isVisible = false
        binding.btnError.isVisible = false
    }

    private fun showError(isShow: Boolean) {
        binding.pbLoading.isInvisible = isShow
        binding.tvError.isVisible = isShow
        binding.btnError.isVisible = isShow
    }
}
