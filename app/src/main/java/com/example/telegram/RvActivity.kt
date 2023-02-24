package com.example.telegram

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.datafaker.Faker

class RvActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recylerview2)

        val recyclerView = findViewById<RecyclerView>(R.id.rvRecyclerView)

        val faker: Faker = Faker()

        val list: ArrayList<Profile> = ArrayList()
        for(i in 1..500){
            list.add(Profile(faker.internet().emailAddress(), faker.phoneNumber().cellPhone().toString()))
        }


        recyclerView.adapter = RvAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        Log.d("hello", "onCreate: ")

    }





}
