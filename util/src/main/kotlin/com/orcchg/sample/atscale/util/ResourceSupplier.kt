package com.orcchg.sample.atscale.util

interface ResourceSupplier {

    fun getResIdByKey(key: String): Int
}
