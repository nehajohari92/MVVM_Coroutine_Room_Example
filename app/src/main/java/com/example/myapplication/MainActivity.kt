package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.QuotesService
import com.example.myapplication.api.RectofitHelper
import com.example.myapplication.repository.quotesRepository
import com.example.myapplication.viewmodels.MainViewModel
import com.example.myapplication.viewmodels.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var  mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview= findViewById<RecyclerView>(R.id.rv_list)

        val repository= (application as ApplicationClass).repository
        mainViewModel= ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.livedataquotes.observe(this, Observer {
           Log.d("test", it.results.toString())
            recyclerview.layoutManager= LinearLayoutManager(this)
            val adapter= RVAdapter(it.results)
            recyclerview.adapter=adapter
        })

    }
}