package com.example.noxosrefactory.service.model

import com.google.gson.annotations.SerializedName

class PersonModel {

    @SerializedName("id")
    lateinit var id: String

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("email")
    lateinit var email: String

    @SerializedName("token")
    lateinit var token:String

//    @SerializedName("token")
//    lateinit var token: String
//
//    @SerializedName("personKey")
//    lateinit var personKey: String
//
//    @SerializedName("name")
//    lateinit var name: String

}

