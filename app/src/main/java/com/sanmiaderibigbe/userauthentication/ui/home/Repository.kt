package com.sanmiaderibigbe.userauthentication.ui.home

import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.data.remote.UserDataDto
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsDataJsonAdapter
import com.sanmiaderibigbe.userauthentication.utils.AppConstants
import com.squareup.moshi.Moshi
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(
    val sharedPreferences: SharedPreferences,
    val moshi: Moshi,
    val apiInterface: ApiInterface
) :
    IRepository {
    override fun getUserData(): UserCredentialsData {
        return UserCredentialsDataJsonAdapter(moshi).fromJson(
            sharedPreferences.getString(
                AppConstants.USER_PREF_KEY,
                ""
            )
        )!!


    }

    override fun getUserId(header: String, email: String): Single<UserDataDto> {
        return apiInterface.getUserId(header, email)
    }
}