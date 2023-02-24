package com.example.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.isInvisible
import androidx.core.widget.addTextChangedListener

class AndroidComponents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_components)

        //spinner

        val genderList: List<String> =
            listOf("please select your gender", "male", "female", "other")
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, genderList
        )


        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedItem = genderList[p2]
                Toast.makeText(
                    this@AndroidComponents,
                    "Selected gender is $selectedItem",
                    Toast.LENGTH_SHORT
                ).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@AndroidComponents,
                    "You have selected nothing",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        //switch

        val switch2 = findViewById<SwitchCompat>(R.id.switch2)
        switch2.textOn = "You have enabled offline mode"
        switch2.textOff = "you have disabled offline mode"
        switch2.isChecked = true
        switch2.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(this, "switch status = $b", Toast.LENGTH_SHORT).show()
            spinner.isInvisible = !b
        }

        //textview and edittext

        val tv = findViewById<TextView>(R.id.textView1)
        val et = findViewById<EditText>(R.id.editText1)

        et.addTextChangedListener {
            tv.text = getFiltered(genderList, it.toString()).toString()
        }

        val list: MutableList<String> = ArrayList()
        et.setOnEditorActionListener { textView, actionId, keyEvent ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val inputText = et.text.toString()
                if (inputText.isBlank()) {
                    Toast.makeText(this, "You should add a string", Toast.LENGTH_SHORT).show()
                    return@setOnEditorActionListener true
                }
                if (list.contains(inputText)) {
                    Toast.makeText(this, "Item already exist", Toast.LENGTH_SHORT).show()
                    return@setOnEditorActionListener true
                }
                list.add(et.text.toString())
                val arrayAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
                spinner.adapter = arrayAdapter


            }
            return@setOnEditorActionListener true
        }

        //seekbar

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2){
                    tv.text = "SeekBar progress is: $p1"
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@AndroidComponents, "current progress is ${p0?.progress}", Toast.LENGTH_SHORT).show()
            }

        })

    }

    fun getFiltered(mList: List<String>, needle: String): List<String>{
        return mList.filter {
            it.startsWith(needle)
        }
    }
}
