package com.sanmiaderibigbe.userauthentication.data.remote


import com.sanmiaderibigbe.userauthentication.data.model.IResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class SignUpReponseDto(@property:Json(name = "msg") override val msg: String, @property:Json(name = "token-pair") override val tokenPair: TokenPair) :
    IResponse