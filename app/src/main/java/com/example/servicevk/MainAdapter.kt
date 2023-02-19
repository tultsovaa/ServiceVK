package com.example.servicevk


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.servicevk.model.ServiceModel

class MainAdapter(private val onItemClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var serviceList = emptyList<ServiceModel>()

    class MainViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.service_icon,
            parent,
            false)
        return MainViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.name_icon).text = serviceList[position].name
        Glide.with(holder.itemView)
            .load(serviceList[position].icon_url)
            .into(holder.itemView.findViewById(R.id.image_icon))
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    fun setList(list: List<ServiceModel>) {
        serviceList = list
        notifyDataSetChanged()
    }
}
