//package com.example.iroom.view.customer.order.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.iroom.R
//import com.example.iroom.databinding.ItemHeaderOrderBinding
//import com.example.iroom.databinding.ItemOrderCardBinding
//import com.example.iroom.model.entity.Order
//import com.example.iroom.model.entity.Status
//import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter
//
//class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>(), StickyRecyclerHeadersAdapter<OrderAdapter.HeaderViewHolder> {
//
//    private var items: List<Order> = listOf()
//
//    fun setData(items: List<Order>) {
//        this.items = items
//        notifyDataSetChanged()
//    }
//
//    inner class HeaderViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
//        val binding =  ItemHeaderOrderBinding.bind(itemView)
//    }
//
//    inner class OrderViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
//        val binding =  ItemOrderCardBinding.bind(itemView)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
//        var view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_order_card, parent, false)
//        return OrderViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
//        var item = items[position]
//        holder.binding.apply {
//            tvOrderId.text = item.orderId
//            tvPrice.text = item.price
//            tvAddress.text = item.address
//            tvApartmentDescription.text = item.description
//            tvService.text = item.apartmentType
//            tvCheckIn.text = item.checkIn
//            tvCheckOut.text = item.checkout
//
//            Glide.with(holder.itemView.context).load(item.apartmentUrl)
//                .error(R.drawable.circle_shape)
//                .placeholder(R.drawable.circle_shape)
//                .into(imApartment)
//
//            when (item.status) {
//                Status.COMPLETED -> {
//                    tvStatus.text = "COMPLETED"
//                }
//                Status.WAITING -> {
//                    tvStatus.visibility = View.GONE
//                    layoutButton.visibility = View.VISIBLE
//                }
//                Status.FAILURE -> {
//
//                }
//
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    override fun getHeaderId(position: Int): Long {
//        return items[position].month.toLong()
//    }
//
//    override fun onCreateHeaderViewHolder(parent: ViewGroup?): HeaderViewHolder {
//        var view = LayoutInflater.from(parent?.context)
//            .inflate(R.layout.item_header_order, parent, false)
//        return HeaderViewHolder(view)
//    }
//
//    override fun onBindHeaderViewHolder(holder: HeaderViewHolder, position: Int) {
//        var item = items[position]
//        holder.binding.apply {
//            tvHeader.text = item.month.toString()
//        }
//    }
//
//
//}