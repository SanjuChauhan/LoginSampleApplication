package com.app.loginapplication.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that captures user information for log in user request
 */
data class LogInUserRequest(
    @SerializedName("userName")
    val userName: String,
    @SerializedName("password")
    val password: String
)