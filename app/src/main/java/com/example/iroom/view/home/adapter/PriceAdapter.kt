package com.example.iroom.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemCircleCityBinding
import com.example.iroom.databinding.ItemPriceBinding
import com.example.iroom.model.entity.City
import com.example.iroom.model.entity.Price

class PriceAdapter : RecyclerView.Adapter<PriceAdapter.PriceViewHolder>() {

    private var items : List<Price> = listOf()

    fun setData(items:List<Price>){
        this.items = items
        notifyDataSetChanged()
    }

    inner class PriceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemPriceBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_price, parent, false)
        return PriceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PriceViewHolder, position: Int) {
        holder.binding.tvDayName.text = items[position].dayName
        holder.binding.tvPrice.text = items[position].price
    }

    override fun getItemCount(): Int {
        return items.size
    }
}