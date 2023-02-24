package com.example.telegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.datafaker.Faker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatRv = findViewById<RecyclerView>(R.id.rvChats)

        val listChats = showChats()
        val filteredList = getFiltered(listChats, "jer")
        Log.d("Filterlist", "onCreate: $filteredList")

        chatRv.adapter = ChatListAdapter(listChats)
        chatRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        chatRv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val ibSearch = findViewById<ImageButton>(R.id.ibSearch)
        ibSearch.setOnClickListener {
            val intent = Intent(this, AndroidComponents::class.java)
            startActivity(intent)
        }
    }

    fun showChats(): List<Chat>{
        val list: MutableList<Chat> = ArrayList()
        list.add(Chat("Jerry","Hi, I am Jerry"))
        list.add(Chat("Tom","Hey Varna1!!!"))
        list.add(Chat("Tom","Hey Varna2!!!"))
        list.add(Chat("Tom","Hey Varna3!!!"))
        list.add(Chat("Micky","Me Micky'sss"))
        list.add(Chat("Donal Duck","Quaa Quaaa Heyyy"))
        return list
    }

    fun getFiltered(originalList: List<Chat>, searchInput: String): List<Chat>{
        return originalList.filter {
            //jerry ->
            it.name.lowercase().startsWith(searchInput.lowercase())
        }
    }
}
