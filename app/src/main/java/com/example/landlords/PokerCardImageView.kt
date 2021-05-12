package com.example.landlords

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class PokerCardImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var number: String = ""
    private var suit: String = ""

}