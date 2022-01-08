package com.example.iroom.view.order.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemHeaderOrderBinding
import com.example.iroom.databinding.ItemOrderCardBinding
import com.example.iroom.model.entity.Order
import com.example.iroom.model.entity.Status
import smartadapter.viewholder.SmartViewHolder

class OrderViewHolder(parentView: ViewGroup) :
    SmartViewHolder<Order>(parentView, R.layout.item_order_card) {
    override fun bind(item: Order) {
        Log.d("TAG", "bind: order")
        ItemOrderCardBinding.bind(itemView).apply {
            tvOrderId.text = item.orderId
            tvPrice.text = item.price
            tvAddress.text = item.address
            tvApartmentDescription.text = item.description
            tvService.text = item.apartmentType
            tvCheckIn.text = item.checkIn
            tvCheckOut.text = item.checkout

            Glide.with(itemView.context).load(item.apartmentUrl)
                .error(R.drawable.circle_shape)
                .placeholder(R.drawable.circle_shape)
                .into(imApartment)

            when (item.status) {
                Status.COMPLETED -> {
                    tvStatus.text = "COMPLETED"
                }
                Status.WAITING -> {
                    tvStatus.visibility = View.GONE
                    layoutButton.visibility = View.VISIBLE
                }
                Status.FAILURE -> {

                }

            }
        }
    }
}