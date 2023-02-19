package com.example.servicevk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.servicevk.databinding.ServiceFragmentBinding
import com.example.servicevk.model.ServiceModel

class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {
    private var serviceList = ArrayList<ServiceModel>()
    fun setServiceList(serviceList: List<ServiceModel>) {
        this.serviceList = serviceList as ArrayList<ServiceModel>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ServiceFragmentBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ServiceFragmentBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(serviceList[position].icon_url)
            .into(holder.binding.image)
        holder.binding.name.text = serviceList[position].name
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }
}
