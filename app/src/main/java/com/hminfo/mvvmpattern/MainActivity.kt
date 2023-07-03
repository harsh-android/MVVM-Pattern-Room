package com.hminfo.mvvmpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hminfo.mvvmpattern.Repository.QuotesRepository
import com.hminfo.mvvmpattern.ViewModel.MainViewModel
import com.hminfo.mvvmpattern.ViewModel.MainViewModelFactory
import com.hminfo.mvvmpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuotesDatabase.getDatabase(this).quoteDao()
        val repository = QuotesRepository(dao)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this,{
            binding.quotes = it.toString()
        })

        binding.btnAddQuotes.setOnClickListener {
            val quote = QuotesEntity(0,"Test","Test")
            mainViewModel.insertQuotes(quote)
        }

    }
}
