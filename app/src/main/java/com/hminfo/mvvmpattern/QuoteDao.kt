package com.hminfo.mvvmpattern

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.jetbrains.annotations.NotNull

@Dao
interface QuoteDao {


    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<QuotesEntity>>

    @Insert
    fun insertQuote(@NotNull quotesEntity: QuotesEntity)

}