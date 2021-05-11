package com.example.landlords

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.landlords.databinding.RowLayoutBinding
import com.example.landlords.databinding.RvCardBinding

class RecyclerAdapter(private val cards: List<Card>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val inflatedView = parent.inflate(R.layout.rv_item_card, false)
        return ViewHolder(RvCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNumber.text = cards[position].rank
        holder.binding.tvSuit.text = cards[position].suit
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    inner class ViewHolder(val binding: RvCardBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}

