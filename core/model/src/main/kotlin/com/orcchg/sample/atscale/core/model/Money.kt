package com.orcchg.sample.atscale.core.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

data class Money(val amount: BigDecimal) {

    operator fun minus(amount: BigDecimal): Money =
        Money(amount = amount.minus(amount))

    operator fun minus(other: Money): Money =
        minus(other.amount)

    companion object {
        val ZERO = Money(amount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP))

        fun by(amount: Double): Money =
            Money(BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP))

        fun by(amount: BigDecimal): Money =
            Money(amount.abs())
    }
}

fun Double.money(): Money = Money.by(this)
