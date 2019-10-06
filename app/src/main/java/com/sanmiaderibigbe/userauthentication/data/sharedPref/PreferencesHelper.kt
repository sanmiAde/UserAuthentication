package com.sanmiaderibigbe.userauthentication.data.sharedPref

interface PreferencesHelper {
    var loggedInMode : Int
    var email : String
    var expires : Long
    fun setLoggedInMode(loggedInMode : LoggedInMode)
}