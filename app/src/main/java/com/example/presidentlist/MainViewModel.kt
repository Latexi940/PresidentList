package com.example.presidentlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel: ViewModel() {
    private val repository: WebServiceRepository = WebServiceRepository()
    var presidentName = ""

    val president = liveData(Dispatchers.IO){
        val retrievedPresident = repository.getTotalHits(presidentName)
        Log.i("MAIN", "Fetching president")
        emit(retrievedPresident)
    }

}