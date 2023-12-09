package com.example.poemapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poemapp.database.poem

class MainActivityData: ViewModel(){

    private val _data = MutableLiveData<List<poem>>()

    val data: LiveData<List<poem>> = _data
    fun setData(data:List<poem>){
        _data.value = data
    }

}