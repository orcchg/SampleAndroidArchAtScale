package com.orcchg.sample.atscale.stocklist.ui.di

import com.orcchg.sample.atscale.stocklist.ui.convert.FakeLogoResByTickerSupplier
import com.orcchg.sample.atscale.util.ResourceSupplier
import dagger.Binds
import dagger.Module

@Module
interface FakeStockListVoConverterModule {

    @Binds
    fun issuerLogoResSupplier(impl: FakeLogoResByTickerSupplier): ResourceSupplier
}
