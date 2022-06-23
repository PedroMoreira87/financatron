package com.example.financatron

import android.view.View

interface OnClickedListener {
    fun onItemClicked(view: View, position: Int)
    fun onItemLongClicked(view: View, position: Int)
}