package com.orcchg.sample.atscale.stockdetails.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CandleListRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        val orientation = (layoutManager as LinearLayoutManager).orientation
        addItemDecoration(DividerItemDecoration(context, orientation))
    }
}
