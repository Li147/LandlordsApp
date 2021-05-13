package com.example.landlords

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.landlords.databinding.RvCardBinding

class RecyclerAdapter(
    vm: ViewModel,
    private val cardDataModels: List<CardDataModel>
    ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(RvCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNumber.text = cardDataModels[position].rank
        holder.binding.tvSuit.text = cardDataModels[position].suit

        holder.binding.cvPlayingCard.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return cardDataModels.size
    }

    inner class ViewHolder(val binding: RvCardBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}

