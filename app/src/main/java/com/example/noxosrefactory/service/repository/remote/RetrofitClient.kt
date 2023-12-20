package com.example.noxosrefactory.service.repository.remote

import com.example.noxosrefactory.service.constants.NoxosConstants
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient private constructor() {
    companion object {

        private lateinit var INSTANCE: Retrofit
        private var token: String = ""

        @OptIn(InternalCoroutinesApi::class)
        private fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor(object : Interceptor { // intercepta a requisição a api
                override fun intercept(chain: Interceptor.Chain): Response {

                    val request = chain.request()
                        .newBuilder()
                        .addHeader(NoxosConstants.HEADER.TOKEN_KEY, token)
                        .build()

                    return chain.proceed(request)
                }

            })


            if (!::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class) {

                    INSTANCE = Retrofit.Builder()
                        .baseUrl("http://192.168.108.176:3333/")
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTANCE
        }

        fun <T> getService(serviceClass: Class<T>): T {
            return getRetrofitInstance().create(serviceClass) // para ter o retorno do retrofit
        }

        fun addHeaders(tokenValue: String) {
            token = tokenValue
        }
    }
}

