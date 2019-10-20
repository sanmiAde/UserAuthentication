package com.sanmiaderibigbe.userauthentication.ui.home

import com.sanmiaderibigbe.userauthentication.data.remote.UserDataDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import io.reactivex.Single

interface IRepository {
    fun getUserData(): UserCredentialsData


    fun getUserId(header: String, email: String): Single<UserDataDto>
}