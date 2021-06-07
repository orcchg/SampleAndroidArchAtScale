package com.orcchg.sample.atscale.stocklist.ui.view

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.sample.atscale.stocklist.ui.R

class StockListEvenOddItemDecoration(
    context: Context,
    @ColorInt private val evenColor: Int,
    @ColorInt private val oddColor: Int
) : RecyclerView.ItemDecoration() {

    private val evenColorRoundDrawable: Drawable

    constructor(context: Context) : this(
        context,
        evenColor = context.getColor(R.color.stock_bg_color_grey),
        oddColor = context.getColor(R.color.white)
    )

    init {
        evenColorRoundDrawable = GradientDrawable().apply {
            setColor(evenColor)
            cornerRadius = context.resources.getDimensionPixelSize(R.dimen.keyline_4).toFloat()
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position % 2 == 0) {
            view.background = evenColorRoundDrawable
        } else {
            view.setBackgroundColor(oddColor)
        }
    }
}
