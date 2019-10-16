package com.sanmiaderibigbe.userauthentication.data.remote

import com.sanmiaderibigbe.userauthentication.data.local.UserModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("signup")
    fun signUp(@Body userModel: UserModel): Single<SignUpReponseDto>
}
