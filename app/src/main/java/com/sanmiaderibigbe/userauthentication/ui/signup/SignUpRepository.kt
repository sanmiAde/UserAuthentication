package com.sanmiaderibigbe.userauthentication.ui.signup

import com.sanmiaderibigbe.userauthentication.data.local.UserModel
import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import io.reactivex.Single
import javax.inject.Inject

class SignUpRepository @Inject constructor(val apiInterface: ApiInterface) : ISignUpRepository {
    override fun signUp(email: String, password: String): Single<SignUpReponseDto> {
        return apiInterface.signUp(UserModel(email, password))
    }

}
