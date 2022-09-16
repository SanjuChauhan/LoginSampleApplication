package com.app.loginapplication.api

import com.app.loginapplication.model.LogInUserRequest
import com.app.loginapplication.model.LoggedInUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DefaultApi {

    /**
     * Login API call
     */
    @POST("login/")
    fun loginAPICall(
        @Body headers: LogInUserRequest
    ): Call<LoggedInUserResponse>

}