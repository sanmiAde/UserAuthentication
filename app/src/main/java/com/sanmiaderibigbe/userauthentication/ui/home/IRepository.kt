package com.sanmiaderibigbe.userauthentication.ui.home

import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData

interface IRepository {
    fun getUserData(): UserCredentialsData
}