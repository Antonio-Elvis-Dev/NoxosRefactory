package com.example.noxosrefactory.service.listener

interface APIListener <T> {
    fun onSuccess(result:T)
    fun onFailure(message: String)
}