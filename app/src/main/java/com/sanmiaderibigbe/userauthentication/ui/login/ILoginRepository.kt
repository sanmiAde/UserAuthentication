package com.sanmiaderibigbe.userauthentication.ui.login

import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import io.reactivex.Single

interface ILoginRepository {
    fun login(email: String, password: String): Single<SignUpReponseDto>

    fun isUserLoggedIn() : Boolean
    fun logOut()

}