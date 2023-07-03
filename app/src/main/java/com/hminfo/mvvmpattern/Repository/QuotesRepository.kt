package com.hminfo.mvvmpattern.Repository

import androidx.lifecycle.LiveData
import com.hminfo.mvvmpattern.QuoteDao
import com.hminfo.mvvmpattern.QuotesEntity

class QuotesRepository(private val quoteDao: QuoteDao)  {

    fun getQuotes() : LiveData<List<QuotesEntity>> {
        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quotesEntity: QuotesEntity) {
        quoteDao.insertQuote(quotesEntity)
    }
}