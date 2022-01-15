package com.example.iroom.view.customer.order.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemOrderCardBinding
import com.example.iroom.model.entity.Order
import com.example.iroom.model.entity.Status
import com.example.iroom.view.customer.order.OrderFragmentDirections
import smartadapter.viewholder.SmartViewHolder

class OrderViewHolder(private val parentView: ViewGroup) :
    SmartViewHolder<Order>(parentView, R.layout.item_order_card) {
     var binding = ItemOrderCardBinding.bind(itemView)
    override fun bind(item: Order) {
        binding.apply {
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

            itemView.setOnClickListener {
                Toast.makeText(parentView.context,"order clicked",Toast.LENGTH_SHORT).show()
            }

            when (item.status) {
                Status.COMPLETED -> {
                    tvStatus.text = "COMPLETED"
                }
                Status.WAITING -> {
                    tvStatus.visibility = View.GONE
                    layoutButton.visibility = View.VISIBLE
                    btnPay.setOnClickListener {
                        parentView.findNavController().navigate(OrderFragmentDirections.actionOrderFragmentToPaymentFragment(orderId = item.orderId))
                    }
                    btnCancel.setOnClickListener {
                        Toast.makeText(parentView.context,"Cancel clicked",Toast.LENGTH_SHORT).show()
                    }
                }
                Status.FAILURE -> {

                }

            }
        }
    }
}