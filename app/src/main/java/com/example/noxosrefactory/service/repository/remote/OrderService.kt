package com.example.noxosrefactory.service.repository.remote

import com.example.noxosrefactory.service.model.OrderDataModel
import com.example.noxosrefactory.service.model.OrderModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderService {
    @POST("order")
    @FormUrlEncoded
    fun createOrder(@Body orderDataModel: OrderDataModel): Call<OrderModel>

    @GET("orders")
    fun orders(): Call<List<OrderModel>>
}