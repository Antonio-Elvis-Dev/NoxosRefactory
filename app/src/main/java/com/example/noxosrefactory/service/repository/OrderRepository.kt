package com.example.noxosrefactory.service.repository

import android.content.Context
import com.example.noxosrefactory.service.repository.remote.OrderService
import com.example.noxosrefactory.service.repository.remote.RetrofitClient

class OrderRepository (val context:Context){

    private val remote = RetrofitClient.getService(OrderService::class.java)

    fun getOrgers(){
        val call = remote.list()

    }

    fun createOrder(){

    }

}