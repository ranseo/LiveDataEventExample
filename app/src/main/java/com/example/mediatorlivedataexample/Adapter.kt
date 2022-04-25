package com.example.mediatorlivedataexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediatorlivedataexample.databinding.ListMainActivityBinding

class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var items : List<String> = listOf()




    class ViewHolder(val binding: ListMainActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : String) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListMainActivityBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
