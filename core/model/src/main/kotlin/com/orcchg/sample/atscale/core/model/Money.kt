package com.orcchg.sample.atscale.core.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

data class Money(val amount: BigDecimal) {

    operator fun minus(amount: BigDecimal): Money =
        Money(amount = this.amount.minus(amount))

    operator fun minus(other: Money): Money =
        minus(other.amount)

    operator fun plus(amount: BigDecimal): Money =
        Money(amount = this.amount.plus(amount))

    operator fun plus(other: Money): Money =
        plus(other.amount)

    operator fun div(amount: BigDecimal): Money =
        Money(amount = this.amount.divide(amount, 2, RoundingMode.HALF_UP))

    operator fun div(other: Money): Money = div(other.amount)

    operator fun times(amount: BigDecimal): Money =
        Money(amount = this.amount.times(amount))

    operator fun times(other: Money): Money = times(other.amount)

    fun isZero(): Boolean = isZero(amount)

    override fun toString(): String =
        toString(locale = Locale.US)

    /**
     * Formats amount of money into string like +5 500 $, which is of good fit
     * for displaying. Zero decimal part will be truncated.
     */
    fun toString(locale: Locale): String {
        val formatter = NumberFormat.getCurrencyInstance(locale)
        formatter.currency = Currency.getInstance(locale)

        val amountDecor =
            if (amount.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                formatter.maximumFractionDigits = 0
                amount.setScale(0, RoundingMode.DOWN)
            } else {
                formatter.maximumFractionDigits = 2
                amount
            }
                .abs() // omit sign

        val signDecor = if (amount.compareTo(BigDecimal.ZERO) != 0) {
            if (amount.signum() >= 0) "" else "-"
        } else ""
        val amountFormatted = formatter.format(amountDecor)
        return "$signDecor$amountFormatted"
    }

    companion object {
        val ZERO = Money(amount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP))

        fun by(amount: Double): Money =
            Money(BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP))

        fun by(amount: BigDecimal): Money =
            Money(amount.abs())

        fun isZero(amount: BigDecimal): Boolean =
            amount.compareTo(BigDecimal.ZERO) == 0

        fun parse(amountAndCurrency: String): Money {
            val stub = '@'
            val s = amountAndCurrency.indexOfFirst { it.isDigit() }
            val e = amountAndCurrency.indexOfLast { it.isDigit() }
            val interest = amountAndCurrency.substring(s, e + 1).replace("[,.]".toRegex(), "$stub")
            val last = interest.indexOfLast { it == stub }
            val balanceStr = if (last != -1) {
                interest.replaceRange(last until last + 1, ".")
            } else interest
            val b = balanceStr.replace("[\\s$stub,]".toRegex(), "")
            val balance = b.toBigDecimal()
            return Money(amount = balance)
        }
    }
}

fun BigDecimal.money(): Money = Money.by(this)
fun Double.money(): Money = Money.by(this)

operator fun Money.div(r: Double): Money = Money.by(amount.divide(BigDecimal.valueOf(r), 2, RoundingMode.HALF_UP))
operator fun Money.times(r: Double): Money = Money.by(amount.times(BigDecimal.valueOf(r)))

fun formatPriceChange(price: Money, change: Money): String {
    val percentage = if (price.isZero()) 0.00 else ((change * 100.0) / price).amount
    val signum = change.amount.signum()
    val sign = if (signum > 0) "+" else ""
    return "$sign$change ($percentage%)"
}
