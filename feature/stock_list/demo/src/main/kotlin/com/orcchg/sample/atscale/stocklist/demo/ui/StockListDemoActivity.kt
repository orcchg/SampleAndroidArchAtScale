package com.orcchg.sample.atscale.stocklist.demo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.orcchg.sample.atscale.androidutil.observe
import com.orcchg.sample.atscale.androidutil.viewBindings
import com.orcchg.sample.atscale.stocklist.demo.databinding.StockActivityDemoBinding
import com.orcchg.sample.atscale.stocklist.demo.di.DaggerStockListDemoActivityComponent
import com.orcchg.sample.atscale.stocklist.demo.viewmodel.StockListViewModel
import com.orcchg.sample.atscale.stocklist.demo.viewmodel.StockListViewModelFactory
import com.orcchg.sample.atscale.stocklist.fake.di.DaggerFakeStockListFeatureComponent
import com.orcchg.sample.atscale.stocklist.ui.adapter.StockListAdapter
import javax.inject.Inject

internal class StockListDemoActivity : AppCompatActivity() {

    @Inject lateinit var stockListAdapter: StockListAdapter
    @Inject lateinit var factory: StockListViewModelFactory
    private val binding by viewBindings(StockActivityDemoBinding::inflate)
    private val viewModel by viewModels<StockListViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerStockListDemoActivityComponent.factory()
            .create(featureApi = DaggerFakeStockListFeatureComponent.create())
            .inject(this)
        super.onCreate(savedInstanceState)

        binding.rvItems.adapter = stockListAdapter
        observe(viewModel.stocks, stockListAdapter::update)
    }
}