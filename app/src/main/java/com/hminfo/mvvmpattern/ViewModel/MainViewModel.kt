package com.hminfo.mvvmpattern.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hminfo.mvvmpattern.QuotesEntity
import com.hminfo.mvvmpattern.Repository.QuotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {


    fun getQuotes(): LiveData<List<QuotesEntity>> {
        return quotesRepository.getQuotes()
    }

    fun insertQuotes(quotesEntity: QuotesEntity) {
        MainScope().launch(Dispatchers.IO) {
            quotesRepository.insertQuotes(quotesEntity)
        }
    }

}