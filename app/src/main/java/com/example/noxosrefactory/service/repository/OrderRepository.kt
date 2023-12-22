package com.example.noxosrefactory.service.repository

import android.content.Context
import com.example.noxosrefactory.service.constants.NoxosConstants
import com.example.noxosrefactory.service.listener.APIListener
import com.example.noxosrefactory.service.model.OrderModel
import com.example.noxosrefactory.service.repository.local.NoxosDatabase
import com.example.noxosrefactory.service.repository.remote.OrderService
import com.example.noxosrefactory.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderRepository(val context: Context) {

    private val remote = RetrofitClient.getService(OrderService::class.java)
    private val database = NoxosDatabase.getDatabase(context).orderDAO()
    fun getOrders(listener: APIListener<List<OrderModel>>) {
        val call = remote.orders()
        call.enqueue(object : Callback<List<OrderModel>> {
            override fun onResponse(
                call: Call<List<OrderModel>>,
                response: Response<List<OrderModel>>
            ) {
                if (response.code() == NoxosConstants.HTTP.SUCCESS) {
                    response.body()?.let { listener.onSuccess(it) }
                } else {
                    listener.onFailure(failResponse(response.errorBody()!!.string()))
                }

            }

            override fun onFailure(call: Call<List<OrderModel>>, t: Throwable) {


            }
        })
    }

    fun save(list: List<OrderModel>) { // salva as orders no banco
        database.save(list)
    }

    private fun failResponse(string: String): String {
        return string
    }

    fun createOrder() {

    }

}