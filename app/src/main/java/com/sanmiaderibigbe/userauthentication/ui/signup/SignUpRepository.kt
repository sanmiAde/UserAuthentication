package com.sanmiaderibigbe.userauthentication.ui.signup

import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.local.UserModel
import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import com.sanmiaderibigbe.userauthentication.utils.SharedPrefUtils
import com.squareup.moshi.Moshi
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SignUpRepository @Inject constructor(
    val apiInterface: ApiInterface,
    val sharedPreferences: SharedPreferences,
    val moshi: Moshi
) : ISignUpRepository {
    override fun saveUSerData(
        responseModel: SignInResponseModel,
        email: String,
        loggedInMode: LoggedInMode
    ): Completable {
        return SharedPrefUtils.saveUserToSharePref(
            responseModel,
            email,
            LoggedInMode.LOGGED_IN,
            sharedPreferences,
            moshi
        )
    }

    override fun signUp(email: String, password: String): Single<SignUpReponseDto> {
        return apiInterface.signUp(UserModel(email, password))
    }

}
