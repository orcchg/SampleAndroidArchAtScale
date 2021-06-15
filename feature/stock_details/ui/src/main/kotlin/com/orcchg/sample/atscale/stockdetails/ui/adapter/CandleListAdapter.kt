package com.orcchg.sample.atscale.stockdetails.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.ui.databinding.StockDetailsCandleListItemBinding
import javax.inject.Inject

class CandleListAdapter @Inject constructor() : RecyclerView.Adapter<CandleViewHolder>() {

    private val candles = mutableListOf<Candle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandleViewHolder =
        StockDetailsCandleListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .let(::CandleViewHolder)

    override fun onBindViewHolder(holder: CandleViewHolder, position: Int) {
        holder.bind(candles[position])
    }

    override fun getItemCount(): Int = candles.size

    @Suppress("NotifyDataSetChanged")
    fun update(candles: List<Candle>) {
        this.candles.clear()
        this.candles.addAll(candles)
        notifyDataSetChanged()
    }
}
