package com.sanmiaderibigbe.userauthentication.data.local

import com.sanmiaderibigbe.userauthentication.data.model.IUser
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserModel(override val email: String, override val password: String) : IUser