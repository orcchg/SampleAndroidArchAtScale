package com.orcchg.sample.atscale.androidutil

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.AttrRes

fun Context.themeColor(@AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.data
}

fun Context.themeAttribute(@AttrRes attrRes: Int): Int = themeColor(attrRes)

val Context.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
