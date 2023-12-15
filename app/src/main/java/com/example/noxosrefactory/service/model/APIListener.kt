package com.example.noxosrefactory.service.model

interface APIListener<T> {
    fun onSuccess(result: T)
    fun onFailure(message: String)
}