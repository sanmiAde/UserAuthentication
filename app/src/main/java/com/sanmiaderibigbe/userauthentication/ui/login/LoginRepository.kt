package com.sanmiaderibigbe.userauthentication.ui.login

import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.data.local.UserModel
import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import com.sanmiaderibigbe.userauthentication.data.sharedPref.PreferencesHelper
import com.sanmiaderibigbe.userauthentication.utils.SharedPrefUtils
import io.reactivex.Single
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val preferenceHelper: PreferencesHelper,
    private val sharedPreferences: SharedPreferences
) : ILoginRepository {
    override fun logOut() {
        SharedPrefUtils.deleteUserFromSharedPref(sharedPreferences)
    }


    //follow unit testing for this code.
    override fun isUserLoggedIn(): Boolean {
      return preferenceHelper.loggedInMode == LoggedInMode.LOGGED_IN.type
    }

    override fun login(email: String, password: String): Single<SignUpReponseDto> {
        return apiInterface.signIn(UserModel(email, password))
    }


}