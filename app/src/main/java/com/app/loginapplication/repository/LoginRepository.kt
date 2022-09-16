package com.app.loginapplication.repository

import com.app.loginapplication.api.APIManager
import com.app.loginapplication.api.APIResponseListener
import com.app.loginapplication.model.LogInUserRequest

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
class LoginRepository {

    fun login(username: String, password: String, listener: APIResponseListener) {
        val request = LogInUserRequest(username, password)
        val call = APIManager.instance?.defaultAPI?.loginAPICall(request)
        APIManager.instance?.callAPI(call, listener)
    }
}