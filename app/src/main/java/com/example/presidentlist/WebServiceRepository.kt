package com.example.presidentlist

class WebServiceRepository() {
    private val call = API.service

    suspend fun getTotalHits(name:String) = call.totalhits("query", "json", "search", name)
}