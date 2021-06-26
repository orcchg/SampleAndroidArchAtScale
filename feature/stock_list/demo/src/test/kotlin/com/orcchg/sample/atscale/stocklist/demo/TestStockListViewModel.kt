package com.orcchg.sample.atscale.stocklist.demo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.orcchg.sample.atscale.stocklist.demo.viewmodel.StockListViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

class TestStockListViewModel {

    @Inject internal lateinit var viewModel: StockListViewModel

    @get:Rule val instantExecutorRule = InstantTaskExecutorRule()

    private val featureApi: TestStockListFeatureComponent =
        DaggerTestStockListFeatureComponent.create()

    init {
        featureApi.inject(this)
    }

    @Test
    fun `test get stocks`() {
        val actualTickers = viewModel.stocks.value?.map { it.ticker }
        val expectedTickers = featureApi.interactor
            .stocks()
            .blockingGet()
            .map { it.ticker }

        Assert.assertNotNull(expectedTickers)
        Assert.assertNotNull(actualTickers)

        Assert.assertArrayEquals(
            expectedTickers.toTypedArray(),
            actualTickers!!.toTypedArray()
        )
    }
}