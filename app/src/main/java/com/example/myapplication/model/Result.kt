package com.example.myapplication.model

import android.os.Build.VERSION
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val author: String,
    val authorSlug: String,
    val content: String
)