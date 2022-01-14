package com.example.iroom.view.notification.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemNotificationTypeABinding
import com.example.iroom.model.entity.Notification
import com.example.iroom.model.entity.NotificationType

class NotificationAdapter(
    val onClick: (Notification) -> Unit
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    private var items: MutableList<Notification> = mutableListOf()

    fun setData(items: MutableList<Notification>) {
//        this.items = items
        val diffCallback = NotificationDiffUtils(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.items.clear()
        this.items.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemNotificationTypeABinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification_type_a, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        var item = items[position]
        holder.binding.apply {
            when (item.type) {
                NotificationType.ACCEPTED -> {
                    tvOrderId.text = item.orderId
                    tvPrice.text = item.price
                    tvStatus.text = holder.itemView.context.getString(R.string.order_has_accepted)
                }
                NotificationType.PROMO -> {
                    tvOrderId.text = item.interested
                    tvPrice.text = item.description
                    tvStatus.text = item.address
                }
            }
            Glide.with(holder.itemView.context).load(item.imageUrl)
                .error(R.drawable.circle_shape)
                .placeholder(R.drawable.circle_shape)
                .into(imApartment)
            tvTime.text = item.time
        }
        holder.itemView.setOnClickListener {
            onClick(item)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NotificationDiffUtils(private val oldList: List<Notification>,
                            private val newList: List<Notification>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  (oldList[oldItemPosition].orderId == newList[newItemPosition].orderId)
//                ||
//                (oldList[oldItemPosition]. == newList[newItemPosition].)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].orderId == newList[newItemPosition].orderId)
    }

}