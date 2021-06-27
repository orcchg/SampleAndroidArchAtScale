package com.orcchg.sample.atscale.stocklist.demo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import com.orcchg.sample.atscale.stocklist.demo.viewmodel.StockListViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

class TestIntegrationStockListViewModel {

    @Inject internal lateinit var viewModel: StockListViewModel

    @get:Rule val instantExecutorRule = InstantTaskExecutorRule()

    private val dataApi: StockListDataApi =
        DaggerTestStockListDataComponent.create()

    private val featureApi: TestIntegrationStockListFeatureComponent =
        DaggerTestIntegrationStockListFeatureComponent.factory()
            .create(stockListDataApi = dataApi)

    init {
        featureApi.inject(this)
    }

    @Test
    fun `test get stocks - data should come from interactor`() {
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

    @Test
    fun `test get stocks - data originates from repository`() {
        val actualTickers = viewModel.stocks.value?.map { it.ticker }
        val expectedTickers = dataApi.repository
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