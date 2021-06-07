package com.orcchg.sample.atscale.stocklist.ui.adapter

import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.sample.atscale.stocklist.ui.databinding.StockListItemBinding
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import com.orcchg.sample.atscale.design.R as Design

class StockViewHolder(
    private val binding: StockListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(vo: StockVO) {
        with(binding) {
            if (vo.logoResId != 0) {
                Glide.with(itemView).load(vo.logoResId)
            } else {
                Glide.with(itemView).load(vo.logoUrl)
            }
                .into(binding.ivStockLogo)

            tvStockTicker.text = vo.ticker
            tvStockIssuer.text = vo.name
        }

        setPrice(vo)
        setPriceChange(vo)
    }

    fun bind(vo: StockVO, payloads: List<Any>) {
        if (payloads.isEmpty()) {
            bind(vo)
            return
        }

        if (payloads.isNotEmpty()) {
            payloads[0].takeIf { it is Set<*> }?.let { it as Set<*> }
                ?.let {
                    if (it.contains(ChangePrice)) {
                        setPrice(vo)
                    }
                    if (it.contains(ChangePriceDailyChange)) {
                        setPriceChange(vo)
                    }
                }
        }
    }

    private fun setPrice(vo: StockVO) {
        binding.tvStockPrice.text = vo.price
    }

    private fun setPriceChange(vo: StockVO) {
        @ColorInt val priceChangeTextColor = when (vo.priceDailyChange[0]) {
            '+' -> ContextCompat.getColor(itemView.context, Design.color.green)
            '-' -> ContextCompat.getColor(itemView.context, Design.color.red)
            else -> ContextCompat.getColor(itemView.context, Design.color.grey)
        }

        with(binding) {
            tvStockPriceChange.text = vo.priceDailyChange
            tvStockPriceChange.setTextColor(priceChangeTextColor)
        }
    }
}
