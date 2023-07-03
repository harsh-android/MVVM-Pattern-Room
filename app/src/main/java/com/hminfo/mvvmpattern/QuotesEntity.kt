package com.hminfo.mvvmpattern

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class QuotesEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var text:String,
    var author:String
)
