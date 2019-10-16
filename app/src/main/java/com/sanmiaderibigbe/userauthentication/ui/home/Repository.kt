package com.sanmiaderibigbe.userauthentication.ui.home

import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDto
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpReponseDtoJsonAdapter
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsDataJsonAdapter
import com.sanmiaderibigbe.userauthentication.utils.AppConstants
import com.squareup.moshi.Moshi
import javax.inject.Inject

class Repository @Inject constructor(val sharedPreferences: SharedPreferences, val moshi: Moshi) :
    IRepository {
    override fun getUserData(): UserCredentialsData {
        return UserCredentialsDataJsonAdapter(moshi).fromJson(
            sharedPreferences.getString(
                AppConstants.USER_PREF_KEY,
                ""
            )
        )!!
    }
}