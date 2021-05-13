package com.example.landlords

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.landlords.databinding.IvCardBinding

class PokerCardImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var value: Int = 1
    private var suit: String = ""

    init {
        inflate(context, R.layout.iv_card, this)
    }

}