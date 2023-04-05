package com.example.myapplication.api

import androidx.room.Query
import com.example.myapplication.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuotesService {

    @GET("/quotes")
    suspend fun getQuotes(@retrofit2.http.Query("page") page: Int) : Response<Quote>

}