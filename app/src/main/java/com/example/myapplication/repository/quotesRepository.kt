package com.example.myapplication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Utils
import com.example.myapplication.api.QuotesService
import com.example.myapplication.db.QuotesDatabase
import com.example.myapplication.model.Quote

class quotesRepository(
    var context: Context,
    var database: QuotesDatabase,
    var quotesService: QuotesService
){

    private val quotelivedata = MutableLiveData<Quote>()

    val livedata :LiveData<Quote>
    get() = quotelivedata

    suspend fun getQuotes(page: Int){

        if(Utils.isInternetAvailable(context)) {
            val result = quotesService.getQuotes(page)
            if (result.body() != null) {
                database.quoteDao().insertQuotes(result.body()!!.results)
                quotelivedata.postValue(result.body())
            }
        }else{
            //val database= QuotesDatabase.getDatabase(context)
            val resultDB= database.quoteDao().selectQuotes()
            val Quotelist= Quote(1,1,1,resultDB,1,1)
            quotelivedata.postValue(Quotelist)
        }
    }
}