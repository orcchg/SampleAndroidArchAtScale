package com.orcchg.sample.atscale.stocklist.ui.di

import com.orcchg.sample.atscale.stocklist.ui.convert.RealLogoResByTickerSupplier
import com.orcchg.sample.atscale.util.ResourceSupplier
import dagger.Binds
import dagger.Module

@Module
interface StockListVoConverterModule {

    @Binds
    fun issuerLogoResSupplier(impl: RealLogoResByTickerSupplier): ResourceSupplier
}
