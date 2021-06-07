package com.orcchg.sample.atscale.stocklist.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import dagger.Reusable
import javax.inject.Inject

@Reusable
class StockListDiffCallback @Inject constructor() : DiffUtil.ItemCallback<StockVO>() {

    override fun areItemsTheSame(oldItem: StockVO, newItem: StockVO): Boolean =
        oldItem.ticker == newItem.ticker

    override fun areContentsTheSame(oldItem: StockVO, newItem: StockVO): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: StockVO, newItem: StockVO): Any? {
        val payloads = mutableSetOf<Any>()
        if (oldItem.price != newItem.price) {
            payloads.add(ChangePrice)
        }
        if (oldItem.priceDailyChange != newItem.priceDailyChange) {
            payloads.add(ChangePriceDailyChange)
        }
        return if (payloads.isEmpty()) null else payloads
    }
}

object ChangePrice
object ChangePriceDailyChange
