package com.sanmiaderibigbe.userauthentication.data.model

import com.sanmiaderibigbe.userauthentication.data.remote.TokenPair


interface IResponse {
    val msg: String
    val tokenPair: TokenPair

}