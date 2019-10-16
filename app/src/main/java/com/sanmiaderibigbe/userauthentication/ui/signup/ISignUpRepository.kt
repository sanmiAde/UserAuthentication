package com.sanmiaderibigbe.userauthentication.ui.signup

import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import io.reactivex.Single

interface ISignUpRepository {

    fun signUp(email: String, password: String): Single<SignUpReponseDto>
}