package com.hminfo.mvvmpattern

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [QuotesEntity::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        private var INSTANCE: QuotesDatabase? = null
        fun getDatabase(context: Context): QuotesDatabase {

            if (INSTANCE == null)
                synchronized(this) {

                    INSTANCE = Room.databaseBuilder(context, QuotesDatabase::class.java, "quotes")
                        .createFromAsset("quotes.db")
                        .build()
                }

            return INSTANCE!!
        }

    }

}