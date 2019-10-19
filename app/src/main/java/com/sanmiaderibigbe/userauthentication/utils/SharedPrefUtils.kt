package com.sanmiaderibigbe.userauthentication.utils

import android.content.SharedPreferences
import androidx.core.content.edit
import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.sharedPref.AppPreferenceHelper
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsDataJsonAdapter
import com.squareup.moshi.Moshi
import io.reactivex.Completable
import io.reactivex.Observable
import timber.log.Timber

object SharedPrefUtils {
    fun saveUserToSharePref(
        user: SignInResponseModel,
        email: String,
        loggedInMode: LoggedInMode,
        sharedPreference: SharedPreferences,
        moshi: Moshi
    ): Completable {
        return Completable.create {
            val userPref = UserCredentialsData(user, email)
            val userJsonPrefString = UserCredentialsDataJsonAdapter(moshi).toJson(userPref)

            Timber.d(userJsonPrefString)
            sharedPreference.edit {
                putString(AppConstants.USER_PREF_KEY, userJsonPrefString)
                putInt(AppPreferenceHelper.PREF_KEY_USER_LOGGED_IN_MODE, loggedInMode.type)
            }
            it.onComplete()
        }


    }

    fun deleteUserFromSharedPref(sharedPreference: SharedPreferences) {
        sharedPreference.edit {
            remove(AppConstants.USER_PREF_KEY)
            putInt(AppPreferenceHelper.PREF_KEY_USER_LOGGED_IN_MODE, LoggedInMode.LOGGED_OUT.type)
        }
    }

}


