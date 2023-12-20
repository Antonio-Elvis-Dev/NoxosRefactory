package com.example.noxosrefactory.service.model

class ValidationModel(message: String = "") {
    private var status: Boolean = true
    private var validationMessage: String = ""

    init {
        if (message != "") {
            validationMessage = message
            status = false
        }
    }

    fun status() = status
    fun message() = validationMessage
}