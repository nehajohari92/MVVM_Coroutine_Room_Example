package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.QuotesService
import com.example.myapplication.model.Quote

class quotesRepository( var quotesService: QuotesService){


    private val quotelivedata = MutableLiveData<Quote>()

    val livedata :LiveData<Quote>
    get() = quotelivedata

    suspend fun getQuotes(page: Int){
        val result= quotesService.getQuotes(page)
        if(result.body()!=null){
            quotelivedata.postValue(result.body())
        }
    }
}