package com.example.noxosrefactory.service.model

import com.google.gson.annotations.SerializedName

class PersonRegisterModel {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("email")
    lateinit var email: String



}