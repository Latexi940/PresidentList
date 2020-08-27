package com.example.presidentlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MAIN", "Starting app")

        val presidentalAdapter = PresidentListAdapter(this, GlobalModel.presidents)

        listView.adapter = presidentalAdapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        listView.setOnItemClickListener { parent, view, position, id ->
            var president = presidentalAdapter.getItem(position)

            infoView.text = president.toString()

            viewModel.presidentName = president.name

            Log.i("MAIN", "President pressed")

            viewModel.president.observe(this, Observer {
                var hits = it.query.searchinfo.totalhits
                Log.i("MAIN", "Hits $hits")
                hitView.text = "HITS: $hits"
            })

        }
    }
}