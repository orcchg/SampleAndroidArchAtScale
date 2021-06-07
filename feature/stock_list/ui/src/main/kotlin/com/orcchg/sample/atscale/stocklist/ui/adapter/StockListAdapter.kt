package com.orcchg.sample.atscale.stocklist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.orcchg.sample.atscale.stocklist.ui.databinding.StockListItemBinding
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import javax.inject.Inject

class StockListAdapter @Inject constructor(
    diffUtil: StockListDiffCallback
) : ListAdapter<StockVO, StockViewHolder>(diffUtil) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder =
        StockListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .let(::StockViewHolder)

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.bind(getItem(position), payloads)
    }

    override fun getItemId(position: Int): Long = getItem(position).id()

    fun update(items: List<StockVO>) {
        submitList(items)
    }
}
