package com.example.noxosrefactory.service.repository

import com.example.noxosrefactory.service.model.LoginModel
import com.example.noxosrefactory.service.model.PersonModel
import com.example.noxosrefactory.service.repository.remote.PersonService
import com.example.noxosrefactory.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonRepository {
   private val remote = RetrofitClient.getService(PersonService::class.java)
    fun login(email: String, password: String) {
        val call = remote.login(LoginModel(email, password))
        call.enqueue(object : Callback<PersonModel>{

            override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
                val s = ""
            }
            override fun onFailure(call: Call<PersonModel>, t: Throwable) {
                val s = ""

            }

        })
    }
}