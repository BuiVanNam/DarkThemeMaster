package com.nambv.demo.darkthememaster.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nambv.demo.darkthememaster.source.DataNewSource
import com.nambv.demo.darkthememaster.source.model.New

/**
 * Created by nambv on 10/6/2020
 */
class MainViewModel : ViewModel() {

    private val _listNews: MutableLiveData<List<New>> = MutableLiveData()
    val listNews: LiveData<List<New>>
        get() = _listNews

    init {
        _listNews.value = DataNewSource.getDataNews()
    }

}