package com.example.iroom.view.order.adapter

import android.view.ViewGroup
import com.example.iroom.R
import com.example.iroom.databinding.ItemHeaderOrderBinding
import com.example.iroom.model.entity.Order
import smartadapter.viewholder.SmartViewHolder
import java.util.*

class HeaderViewHolder(parentView: ViewGroup) : SmartViewHolder<String>(parentView, R.layout.item_header_order)  {
    override fun bind(item: String) {
        ItemHeaderOrderBinding.bind(itemView).apply {
            tvHeader.text = item
        }
    }
}