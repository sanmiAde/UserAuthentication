package com.sanmiaderibigbe.userauthentication.data.remote

sealed class SignInResult {
    object Loading : SignInResult()
    data class Success(val result: Boolean) : SignInResult()
    data class Error(val result: Boolean, val errorMessage: String) : SignInResult()
}

