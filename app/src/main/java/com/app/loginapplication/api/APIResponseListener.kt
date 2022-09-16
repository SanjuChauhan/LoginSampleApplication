package com.app.loginapplication.api

interface APIResponseListener {
    fun onSuccess(response: Any?)
    fun onFail(message: String?)
}