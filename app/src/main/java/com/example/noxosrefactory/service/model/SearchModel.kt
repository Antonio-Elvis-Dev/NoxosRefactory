package com.example.noxosrefactory.service.model

import com.google.gson.annotations.SerializedName

class SearchModel {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("Description")
    var descripition: String = ""

    @SerializedName("Seller")
    var seller: String = ""

    @SerializedName("CEP")
    var cep: String = ""

    @SerializedName("Sale")
    var sale: String = ""

    @SerializedName("LastSale")
    var last_sale: String = ""
}