package com.sanmiaderibigbe.userauthentication.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class TokenPair(
    @property:Json(name = "access_token")
    val accessToken: String, @property:Json(name = "refresh_token")
    val refreshToken: String
) {

}