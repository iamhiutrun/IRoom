package com.example.iroom.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iroom.R
import com.example.iroom.databinding.ItemConvenientBinding

class ConvenientAdapter : RecyclerView.Adapter<ConvenientAdapter.ConvenientViewHolder>() {

    private var items: List<String> = listOf()

    fun setData(items: List<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ConvenientViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemConvenientBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvenientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_convenient, parent, false)
        return ConvenientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConvenientViewHolder, position: Int) {
        holder.binding.tvConvenient.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }
}