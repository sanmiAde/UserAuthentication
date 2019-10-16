package com.sanmiaderibigbe.userauthentication.data.local

import com.sanmiaderibigbe.userauthentication.data.model.IResponse
import com.sanmiaderibigbe.userauthentication.data.remote.TokenPair

class SignInResponseModel(override val msg: String, override val tokenPair: TokenPair) : IResponse