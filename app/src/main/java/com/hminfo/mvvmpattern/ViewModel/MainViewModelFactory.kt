package com.hminfo.mvvmpattern.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hminfo.mvvmpattern.Repository.QuotesRepository

class MainViewModelFactory(private val quotesRepository: QuotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quotesRepository) as T
    }
}