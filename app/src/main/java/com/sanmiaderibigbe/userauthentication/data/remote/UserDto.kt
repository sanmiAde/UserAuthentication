package com.sanmiaderibigbe.userauthentication.data.remote

import com.sanmiaderibigbe.userauthentication.data.model.IUser
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDataDto(
    @property:Json(name = "email") val email: String,
    @property:Json(name = "Password") val password: String,
    @property:Json(name = "id") val userId: String
)