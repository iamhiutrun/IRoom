package com.example.iroom.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iroom.R
import com.example.iroom.databinding.ItemCityChipBinding
import com.example.iroom.model.entity.City

class ChipAdapter : RecyclerView.Adapter<ChipAdapter.ChipViewHolder>() {

    private var items: List<City> = listOf()

    fun setData(items: List<City>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ChipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemCityChipBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city_chip, parent, false)
        return ChipViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) {
        holder.binding.btnCity.text = items[position].cityName
    }

    override fun getItemCount(): Int {
        return items.size
    }
}