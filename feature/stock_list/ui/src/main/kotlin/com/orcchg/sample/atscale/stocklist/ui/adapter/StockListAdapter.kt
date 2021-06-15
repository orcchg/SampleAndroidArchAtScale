package com.orcchg.sample.atscale.stocklist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.sample.atscale.androidutil.clickThrottle
import com.orcchg.sample.atscale.stocklist.ui.databinding.StockListItemBinding
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import javax.inject.Inject

class StockListAdapter @Inject constructor(
    diffUtil: StockListDiffCallback
) : ListAdapter<StockVO, StockViewHolder>(diffUtil) {

    var itemClickListener: ((model: StockVO) -> Unit)? = null

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder =
        StockListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .let(::StockViewHolder).apply {
                itemView.clicks().clickThrottle().subscribe {
                    bindingAdapterPosition
                        .takeIf { it != RecyclerView.NO_POSITION }
                        ?.let { itemClickListener?.invoke(getItem(it)) }
                }
            }

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
