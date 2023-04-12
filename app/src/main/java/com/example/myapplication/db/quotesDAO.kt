package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.Quote
import com.example.myapplication.model.Result


@Dao
interface quotesDAO {

    @Insert
     fun insertQuotes(quotes : List<Result>)

    @Query("SELECT * FROM quote")
     fun selectQuotes() : List<Result>

}