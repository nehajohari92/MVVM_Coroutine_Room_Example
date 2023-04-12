package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [com.example.myapplication.model.Result::class], version = 1)
abstract class QuotesDatabase :RoomDatabase() {

    abstract fun quoteDao() : quotesDAO
        companion object{
            @Volatile
            private var INSTANCE: QuotesDatabase? = null

            fun getDatabase(context: Context): QuotesDatabase {
                if (INSTANCE == null) {
                    synchronized(this){
                        INSTANCE = Room.databaseBuilder(context,
                            QuotesDatabase::class.java,
                            "quoteDB")
                            .build()
                    }
                }
                return INSTANCE!!
            }
        }
}