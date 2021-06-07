package com.orcchg.sample.atscale.core.network.impl.di

import com.orcchg.sample.atscale.core.network.impl.parser.BigDecimalAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
internal object NetworkCoreLibModule {

    @Provides
    fun moshi() =
        Moshi.Builder()
            .add(BigDecimalAdapter)
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    @Reusable
    fun retrofit(client: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://finnhub.io/api/v1/")
            .build()
}