package com.example.mediatorlivedataexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val firList = mutableListOf<String>()
    val secList = mutableListOf<String>()

    private val _fir = MutableLiveData<List<String>>()
    val fir : LiveData<List<String>>
        get() = _fir

    private val _sec = MutableLiveData<List<String>>()
    val sec : LiveData<List<String>>
        get() = _sec


    private val _convert = MutableLiveData<Event<List<String>>>()
    val convert : LiveData<Event<List<String>>>
            get() = _convert

    fun setFirValue() {
        _fir.value = firList
    }

    fun setSecValue() {
        _sec.value = secList
    }

    fun onFirBtn() {
        val value = fir.value
        value?.let{
            Log.i("메인뷰모델", "${value}")
            _convert.value = Event(it)
        }
    }

    fun onSecBtn() {
        val value = sec.value
        value?.let{
            Log.i("메인뷰모델", "${value}")
            _convert.value = Event(it)
        }
    }




}