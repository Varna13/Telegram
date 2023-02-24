package com.example.telegram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RvAdapter(
    private val listProfile: List<Profile>
): Adapter<RvAdapter.RvViewHolder>() {

    inner class RvViewHolder(private val itemRv: View):RecyclerView.ViewHolder(itemRv){
        private val tvEmail = itemRv.findViewById<TextView>(R.id.tvEmail)
        private val tvPhone = itemRv.findViewById<TextView>(R.id.tvPhone)
        fun bind(profile: Profile){
            tvEmail.text = profile.email
            tvPhone.text = profile.mobile
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
       return RvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rvitem, parent,  false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(listProfile[position])
    }

    override fun getItemCount(): Int {
        return listProfile.size
    }
}
