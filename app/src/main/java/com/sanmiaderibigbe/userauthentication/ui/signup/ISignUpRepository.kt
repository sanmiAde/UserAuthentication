package com.sanmiaderibigbe.userauthentication.ui.signup

import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import io.reactivex.Completable
import io.reactivex.Single

interface ISignUpRepository {

    fun signUp(email: String, password: String): Single<SignUpReponseDto>

    fun saveUSerData(
        responseModel: SignInResponseModel,
        email: String,
        loggedInMode: LoggedInMode
    ): Completable
}