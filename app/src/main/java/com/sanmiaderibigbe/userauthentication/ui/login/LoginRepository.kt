package com.sanmiaderibigbe.userauthentication.ui.login

import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import com.sanmiaderibigbe.userauthentication.data.sharedPref.PreferencesHelper
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiInterface: ApiInterface, private val preferenceHelper: PreferencesHelper) : ILoginRepository {

    //follow unit testing for this code.
    override fun isUserLoggedIn(): Boolean {
      return preferenceHelper.loggedInMode == LoggedInMode.LOGGED_IN.type
    }

    override fun login(email: String, password: String) {

    }


}