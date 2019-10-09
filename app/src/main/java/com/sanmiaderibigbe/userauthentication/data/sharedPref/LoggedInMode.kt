package com.sanmiaderibigbe.userauthentication.data.sharedPref

//are enum not bad in android. A sealed class would do just fine
enum class LoggedInMode(val type : Int) {
        LOGGED_OUT(0),
        LOGGED_IN(1)
}
