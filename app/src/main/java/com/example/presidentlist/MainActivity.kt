package com.example.presidentlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presidentalAdapter = PresidentListAdapter(this, GlobalModel.presidents)

        listView.adapter = presidentalAdapter

        listView.setOnItemClickListener{ parent, view,position, id ->

            var tv = findViewById<TextView>(R.id.infoView)
            tv.text = presidentalAdapter.getItem(position).toString()
        }
    }
}