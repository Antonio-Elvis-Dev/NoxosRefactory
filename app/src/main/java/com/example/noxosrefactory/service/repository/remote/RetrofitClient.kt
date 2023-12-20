package com.example.noxosrefactory.service.repository.remote

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient private constructor() {
    companion object {

        private lateinit var INSTANCE: Retrofit

        @OptIn(InternalCoroutinesApi::class)
        private fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()

            if (!::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class){

                INSTANCE = Retrofit.Builder()
                    .baseUrl("http://192.168.108.176:3333/")
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                }
            }
            return INSTANCE
        }
        fun<T> getService(serviceClass: Class<T>):T{
            return getRetrofitInstance().create(serviceClass) // para ter o retorno do retrofit
        }
    }
}

