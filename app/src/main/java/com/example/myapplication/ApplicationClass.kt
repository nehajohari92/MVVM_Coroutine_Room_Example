package com.example.myapplication

import android.app.Application
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.QuotesService
import com.example.myapplication.api.RectofitHelper
import com.example.myapplication.repository.quotesRepository

class ApplicationClass : Application() {

    lateinit var repository: quotesRepository
    override fun onCreate() {
        super.onCreate()

        initiateRectofit()

    }

    private fun initiateRectofit() {
        val quotesService= RectofitHelper.getInstance().create(QuotesService::class.java)
         repository= quotesRepository(quotesService)
    }
}