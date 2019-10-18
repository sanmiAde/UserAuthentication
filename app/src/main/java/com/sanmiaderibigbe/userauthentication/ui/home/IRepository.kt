package com.sanmiaderibigbe.userauthentication.ui.home

import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import com.sanmiaderibigbe.userauthentication.data.remote.UserDataDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import io.reactivex.Single
import retrofit2.Response

interface IRepository {
    fun getUserData(): UserCredentialsData


    fun getUserId(header: String, email: String): Single<Response<UserDataDto>>
}