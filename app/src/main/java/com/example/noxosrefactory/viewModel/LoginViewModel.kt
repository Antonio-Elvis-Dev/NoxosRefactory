package com.example.noxosrefactory.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.noxosrefactory.service.repository.PersonRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository()

    fun doLogin(email:String,password:String) {
        personRepository.login(email,password)

    }


    fun verifyLoggedUser() {}
}