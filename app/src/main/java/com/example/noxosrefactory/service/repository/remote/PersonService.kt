package com.example.noxosrefactory.service.repository.remote

import com.example.noxosrefactory.service.model.LoginDataModel
import com.example.noxosrefactory.service.model.PersonModel
import com.example.noxosrefactory.service.model.PersonRegisterModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PersonService {

    @POST("session")
    fun login(@Body loginDataModel: LoginDataModel): Call<PersonModel> // bug de login resolvido com um data class -> LoginModel

//    fun login(
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): Call<PersonModel>


    @POST("users")
    @FormUrlEncoded
    fun create(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<PersonRegisterModel>
}