package com.sanmiaderibigbe.userauthentication.data.sharedPref

interface PreferencesHelper {
    var loggedInMode : Int
    var email : String
    var userId : String
    var accessToken : String
    var refreshToken : String
    var expires : Long

}