package com.sanmiaderibigbe.userauthentication.data.sharedPref

import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.local.UserModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserCredentialsData(val signInModel: SignInResponseModel, val email: String)
