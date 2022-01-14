package com.example.iroom.view.customer.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemApartmentLargeBinding
import com.example.iroom.databinding.ItemApartmentSmallBinding
import com.example.iroom.model.entity.Apartment

class ApartmentAdapter(var isLarge: Boolean = false, var onClick: (Apartment)->Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Apartment> = listOf()

    fun setData(items: List<Apartment>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ApartmentSmallViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemApartmentSmallBinding.bind(view)
    }

    inner class ApartmentLargeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemApartmentLargeBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (isLarge) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_apartment_large, parent, false)
            ApartmentLargeViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_apartment_small, parent, false)
            ApartmentSmallViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val apartment = items[position]
        holder.itemView.setOnClickListener {
            onClick(apartment)
        }
        when (holder) {
            is ApartmentLargeViewHolder -> {
                holder.binding.tvApartmentDescription.text = apartment.description
                holder.binding.tvAddress.text = apartment.address
                holder.binding.tvFigures.text = holder.itemView.context.getString(R.string.figures)
                    .format(apartment.guest, apartment.bedroom, apartment.bath)
                Glide.with(holder.itemView.context).load(apartment.apartmentUrl)
                    .error(R.drawable.circle_shape)
                    .placeholder(R.drawable.circle_shape)
                    .into(holder.binding.imApartment)
            }
            is ApartmentSmallViewHolder -> {
                holder.binding.tvApartmentDescription.text = apartment.description
                holder.binding.tvFigures.text = holder.itemView.context.getString(R.string.figures)
                    .format(apartment.guest, apartment.bedroom, apartment.bath)
                Glide.with(holder.itemView.context).load(apartment.apartmentUrl)
                    .error(R.drawable.circle_shape)
                    .placeholder(R.drawable.circle_shape)
                    .into(holder.binding.imApartment)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}