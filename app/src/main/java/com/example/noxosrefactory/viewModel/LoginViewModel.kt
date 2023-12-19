package com.example.noxosrefactory.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noxosrefactory.service.listener.APIListener
import com.example.noxosrefactory.service.model.PersonModel
import com.example.noxosrefactory.service.model.ValidationModel
import com.example.noxosrefactory.service.repository.PersonRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository(application.applicationContext)

    private val _login = MutableLiveData<ValidationModel>()

    val login: LiveData<ValidationModel> = _login
    


    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {
                _login.value = ValidationModel()
            }


            override fun onFailure(message: String) {
                _login.value = ValidationModel(message)
            }


        })

    }


    fun verifyLoggedUser() {}
}