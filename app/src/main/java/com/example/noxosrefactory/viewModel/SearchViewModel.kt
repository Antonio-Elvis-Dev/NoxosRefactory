package com.example.noxosrefactory.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noxosrefactory.service.listener.APIListener
import com.example.noxosrefactory.service.model.SearchModel

class SearchViewModel(application: Application): AndroidViewModel(application) {

    private var searchFilter = 0


    private val _tasks = MutableLiveData<List<SearchModel>>()
    val searchs:LiveData<List<SearchModel>> = _tasks

    fun list(filter:Int){
        searchFilter = filter
        val listener = object : APIListener<List<SearchModel>> {
            override fun onSuccess(result: List<SearchModel>){
                result.forEach{

                }
            }

            override fun onFailure(message: String) {
                TODO("Not yet implemented")
            }
        }
    }
}