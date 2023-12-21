package com.example.noxosrefactory.service.repository.remote

import com.example.noxosrefactory.service.model.OrderDataModel
import com.example.noxosrefactory.service.model.OrderModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderService {
    @POST("order")
    fun list(@Body orderDataModel: OrderDataModel): Call<List<OrderModel>>

    @GET("orders")
    fun list(): Call<List<OrderModel>>
}