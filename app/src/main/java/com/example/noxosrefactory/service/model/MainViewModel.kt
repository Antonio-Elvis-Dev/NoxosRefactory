package com.example.noxosrefactory.service.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun logout() {

    }

    fun loadUserName() {

    }
}