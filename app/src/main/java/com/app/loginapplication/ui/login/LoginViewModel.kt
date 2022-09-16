package com.app.loginapplication.ui.login

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.loginapplication.R
import com.app.loginapplication.api.APIResponseListener
import com.app.loginapplication.repository.LoginRepository
import com.app.loginapplication.model.LoggedInUserResponse

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    val loginFormState = MutableLiveData<LoginFormState>()
    val loginResult = MutableLiveData<LoginResult>()

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        loginRepository.login(username, password, object : APIResponseListener {
            override fun onSuccess(response: Any?) {
                val logInResponse = response as LoggedInUserResponse
                loginResult.value = LoginResult(success = logInResponse)
            }

            override fun onFail(message: String?) {
                loginResult.value = LoginResult(error = message)
            }
        })
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            loginFormState.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            loginFormState.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            loginFormState.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}