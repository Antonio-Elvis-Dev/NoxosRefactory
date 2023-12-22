package com.example.noxosrefactory.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noxosrefactory.service.constants.NoxosConstants
import com.example.noxosrefactory.service.listener.APIListener
import com.example.noxosrefactory.service.model.OrderModel
import com.example.noxosrefactory.service.model.PersonModel
import com.example.noxosrefactory.service.model.ValidationModel
import com.example.noxosrefactory.service.repository.OrderRepository
import com.example.noxosrefactory.service.repository.PersonRepository
import com.example.noxosrefactory.service.repository.SecurityPreferences
import com.example.noxosrefactory.service.repository.remote.RetrofitClient
import retrofit2.Retrofit

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository = PersonRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val orderRepository = OrderRepository(application.applicationContext)

    private val _login = MutableLiveData<ValidationModel>()
    val login: LiveData<ValidationModel> = _login

    private val _loggedUser = MutableLiveData<Boolean>()
    val loggedUser: LiveData<Boolean> = _loggedUser

    fun doLogin(email: String, password: String) {
        personRepository.login(email, password, object : APIListener<PersonModel> {
            override fun onSuccess(result: PersonModel) {

                securityPreferences.store(NoxosConstants.SHARED.TOKEN_KEY, result.token)
                securityPreferences.store(NoxosConstants.SHARED.PERSON_KEY, result.id)
                securityPreferences.store(NoxosConstants.SHARED.PERSON_NAME, result.name)
                securityPreferences.store(NoxosConstants.SHARED.PERSON_EMAIL, result.email)

                RetrofitClient.addHeaders(result.token)

                _login.value = ValidationModel()
            }

            override fun onFailure(message: String) {
                _login.value = ValidationModel(message)
            }
        })

    }

    fun verifyLoggedUser() {

        val token = securityPreferences.get(NoxosConstants.SHARED.TOKEN_KEY)
        RetrofitClient.addHeaders(token)

        val logged = (token != "")
        _loggedUser.value = logged

        if (!logged) {
            orderRepository.getOrders(object : APIListener<List<OrderModel>> {
                override fun onSuccess(result: List<OrderModel>) {
                    orderRepository.save(result) // chama a função de salvar no banco
                }

                override fun onFailure(message: String) {
                    val s = ""
                }

            })
        }

    }


}