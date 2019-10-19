package com.sanmiaderibigbe.userauthentication.ui.login

import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode

interface ILoginRepository {
    fun login(email : String, password : String)

    fun isUserLoggedIn() : Boolean
    fun logOut()

}