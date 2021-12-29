package com.example.iroom.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemCircleCityBinding
import com.example.iroom.model.entity.City

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private var items : List<City> = listOf()

    fun setData(items:List<City>){
        this.items = items
        notifyDataSetChanged()
    }

    inner class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemCircleCityBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_circle_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.binding.tvCityName.text = items[position].cityName
        Glide.with(holder.itemView.context).load(items[position].cityImage)
            .error(R.drawable.circle_shape)
            .placeholder(R.drawable.circle_shape)
            .into(holder.binding.imCity)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}