package com.example.noxosrefactory.service.repository

import android.content.Context
import com.example.noxosrefactory.R
import com.example.noxosrefactory.service.constants.NoxosConstants
import com.example.noxosrefactory.service.listener.APIListener
import com.example.noxosrefactory.service.model.LoginModel
import com.example.noxosrefactory.service.model.PersonModel
import com.example.noxosrefactory.service.repository.remote.PersonService
import com.example.noxosrefactory.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonRepository(val context: Context) {
    private val remote = RetrofitClient.getService(PersonService::class.java)

    /*
    * onFalilure - retorna uma excessão - String
    * onResponse - 200 - PersonModel
    * onResponse - 404 - String
    * */
    fun login(email: String, password: String, listener: APIListener<PersonModel>) {
        val call = remote.login(LoginModel(email, password))
        call.enqueue(object : Callback<PersonModel> {

            override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
                if (response.code() == NoxosConstants.HTTP.SUCCESS) {
                    response.body()?.let { listener.onSuccess(it) }

                } else {

                    listener.onFailure(failResponse(response.errorBody()!!.string()))
                }
            }

            override fun onFailure(call: Call<PersonModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

        })
    }

    private fun failResponse(str: String): String {
        return Gson().fromJson(str, String::class.java)
    }

}