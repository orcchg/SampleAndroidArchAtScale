package com.orcchg.sample.atscale.util

interface Converter<F, T> {

    fun convert(from: F): T
    fun convertList(from: List<F>): List<T> = from.map(::convert)

    fun revert(from: T): F { throw UnsupportedOperationException("Revert not supported") }
    fun revertList(from: List<T>): List<F> = from.map(::revert)
}
