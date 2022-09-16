package com.app.loginapplication.model

import com.google.gson.annotations.SerializedName

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUserResponse(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("name")
    val name: String
)