package com.orcchg.sample.atscale.stockdetails.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.orcchg.sample.atscale.androidutil.argument
import com.orcchg.sample.atscale.androidutil.observe
import com.orcchg.sample.atscale.androidutil.viewBindings
import com.orcchg.sample.atscale.core.ui.BaseFragment
import com.orcchg.sample.atscale.di.getFeature
import com.orcchg.sample.atscale.stockdetails.main.R
import com.orcchg.sample.atscale.stockdetails.main.databinding.StockDetailsFragmentBinding
import com.orcchg.sample.atscale.stockdetails.main.di.DaggerStockDetailsFragmentComponent
import com.orcchg.sample.atscale.stockdetails.main.viewmodel.StockDetailsViewModel
import com.orcchg.sample.atscale.stockdetails.main.viewmodel.StockDetailsViewModelFactory
import com.orcchg.sample.atscale.stockdetails.ui.adapter.CandleListAdapter
import javax.inject.Inject

class StockDetailsFragment : BaseFragment(R.layout.stock_details_fragment) {

    @Inject lateinit var candleListAdapter: CandleListAdapter
    @Inject lateinit var factory: StockDetailsViewModelFactory
    private val ticker by argument<String>("ticker")
    private val binding by viewBindings(StockDetailsFragmentBinding::bind)
    private val viewModel by viewModels<StockDetailsViewModel> { factory }

    @Suppress("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerStockDetailsFragmentComponent.factory()
            .create(
                ticker = ticker,
                featureApi = api.getFeature(),
                stockListFeatureApi = api.getFeature()
            )
            .inject(this)
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.candles, candleListAdapter::update)
        observe(viewModel.stock) {
            binding.tvStockName.text = it.name
            binding.tvStockTicker.text = it.ticker
        }
    }
}
