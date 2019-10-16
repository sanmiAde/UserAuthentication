package com.sanmiaderibigbe.userauthentication.data.remote

sealed class SignUpResult {

    object Loading : SignUpResult()
    data class Success(val result: Boolean) : SignUpResult()
    data class Error(val result: Boolean, val errorMessage: String) : SignUpResult()
}