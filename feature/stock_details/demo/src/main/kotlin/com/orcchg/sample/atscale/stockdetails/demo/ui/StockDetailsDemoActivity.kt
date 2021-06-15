package com.orcchg.sample.atscale.stockdetails.demo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.orcchg.sample.atscale.androidutil.observe
import com.orcchg.sample.atscale.androidutil.viewBindings
import com.orcchg.sample.atscale.stockdetails.demo.databinding.StockDetailsDemoActivityBinding
import com.orcchg.sample.atscale.stockdetails.demo.di.DaggerStockDetailsDemoActivityComponent
import com.orcchg.sample.atscale.stockdetails.demo.viewmodel.StockDetailsViewModel
import com.orcchg.sample.atscale.stockdetails.demo.viewmodel.StockDetailsViewModelFactory
import com.orcchg.sample.atscale.stockdetails.fake.di.DaggerFakeStockDetailsFeatureComponent
import com.orcchg.sample.atscale.stockdetails.ui.adapter.CandleListAdapter
import javax.inject.Inject

internal class StockDetailsDemoActivity : AppCompatActivity() {

    @Inject lateinit var candleListAdapter: CandleListAdapter
    @Inject lateinit var factory: StockDetailsViewModelFactory
    private val binding by viewBindings(StockDetailsDemoActivityBinding::inflate)
    private val viewModel by viewModels<StockDetailsViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerStockDetailsDemoActivityComponent.factory()
            .create(
                ticker = "AAPL", // hardcoded for demo
                featureApi = DaggerFakeStockDetailsFeatureComponent.create()
            )
            .inject(this)
        super.onCreate(savedInstanceState)

        binding.rvCandles.adapter = candleListAdapter
        observe(viewModel.candles, candleListAdapter::update)
    }
}
