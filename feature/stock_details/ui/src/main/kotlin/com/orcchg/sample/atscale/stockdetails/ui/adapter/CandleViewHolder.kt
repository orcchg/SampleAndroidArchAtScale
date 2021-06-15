package com.orcchg.sample.atscale.stockdetails.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.ui.databinding.StockDetailsCandleListItemBinding

class CandleViewHolder(
    private val binding: StockDetailsCandleListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Candle) {
        binding.tvCandlePrice.text = model.closePrice.toString()
    }
}
