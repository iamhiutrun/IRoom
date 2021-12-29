package com.example.iroom.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemApartmentSmallBinding
import com.example.iroom.model.entity.Apartment

class ApartmentAdapter : RecyclerView.Adapter<ApartmentAdapter.ApartmentViewHolder>() {

    private var items : List<Apartment> = listOf()

    fun setData(items:List<Apartment>){
        this.items = items
        notifyDataSetChanged()
    }

    inner class ApartmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemApartmentSmallBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_apartment_small, parent, false)
        return ApartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        val apartment = items[position]
        holder.binding.tvApartmentDescription.text = apartment.description
        holder.binding.tvFigures.text = holder.itemView.context.getString(R.string.figures).format(apartment.guest,apartment.bedroom,apartment.bath)
        Glide.with(holder.itemView.context).load(apartment.apartmentUrl)
            .error(R.drawable.circle_shape)
            .placeholder(R.drawable.circle_shape)
            .into(holder.binding.imApartment)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}