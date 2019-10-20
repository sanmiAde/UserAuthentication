package com.sanmiaderibigbe.userauthentication.data.remote

import com.sanmiaderibigbe.userauthentication.data.local.UserModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @POST("signup")
    fun signUp(@Body userModel: UserModel): Single<SignUpReponseDto>

    @GET("getuserid/{email}")
    fun getUserId(@Header("Authorization") authToken: String, @Path("email") email: String): Single<Response<UserDataDto>>

    @POST("signin")
    fun signIn(@Body userModel: UserModel): Single<SignUpReponseDto>
}
