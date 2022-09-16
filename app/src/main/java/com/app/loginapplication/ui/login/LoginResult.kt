package com.app.loginapplication.ui.login

import com.app.loginapplication.model.LoggedInUserResponse

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserResponse? = null,
    val error: String? = null
)