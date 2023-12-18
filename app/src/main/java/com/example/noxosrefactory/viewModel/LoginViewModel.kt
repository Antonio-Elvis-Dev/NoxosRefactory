package com.example.noxosrefactory.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noxosrefactory.service.listener.APIListener
import com.example.noxosrefactory.service.model.PersonModel
import com.example.noxosrefactory.service.repository.PersonRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository(application.applicationContext)

    private val _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean> = _login
    
    private val _failure = MutableLiveData<String>()
    val failure: LiveData<String> = _failure


    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {
                _login.value = true
            }


            override fun onFailure(message: String) {
                _failure.value = message
            }


        })

    }


    fun verifyLoggedUser() {}
}