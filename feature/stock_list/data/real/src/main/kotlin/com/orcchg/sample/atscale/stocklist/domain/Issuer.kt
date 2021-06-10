package com.orcchg.sample.atscale.stocklist.domain

data class Issuer(
    val name: String,
    val country: String,
    val ticker: String,
    val logoUrl: String? = null
)
