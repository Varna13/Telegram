package com.example.telegram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ChatListAdapter(
    private val chatList: List<Chat>
):Adapter<ChatListAdapter.ChatListViewHolder>() {

    inner class ChatListViewHolder(private val itemChat: View): RecyclerView.ViewHolder(itemChat){
        val personName = itemChat.findViewById<TextView>(R.id.tvName)
        val personMessage = itemChat.findViewById<TextView>(R.id.tvMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        return ChatListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chatlist, parent, false))
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        val chat = chatList[position]
        holder.personName.text = chat.name
        holder.personMessage.text = chat.message
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}
