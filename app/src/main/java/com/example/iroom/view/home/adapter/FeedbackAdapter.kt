package com.example.iroom.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.ItemFeedbackBinding
import com.example.iroom.model.entity.Feedback

class FeedbackAdapter : RecyclerView.Adapter<FeedbackAdapter.FeedbackHolder>() {

    private var items : List<Feedback> = listOf()

    fun setData(items:List<Feedback>){
        this.items = items
        notifyDataSetChanged()
    }

    inner class FeedbackHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemFeedbackBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feedback, parent, false)
        return FeedbackHolder(view)
    }

    override fun onBindViewHolder(holder: FeedbackHolder, position: Int) {
        holder.binding.tvHostName.text = items[position].fullName
        Glide.with(holder.itemView.context).load(items[position].avatar)
            .error(R.drawable.circle_shape)
            .placeholder(R.drawable.circle_shape)
            .into(holder.binding.imAvatar)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}