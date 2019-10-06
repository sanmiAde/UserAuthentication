package com.sanmiaderibigbe.userauthentication.data.sharedPref

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.sanmiaderibigbe.userauthentication.utils.AppConstants
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(val context: Application) :
    PreferencesHelper {

    private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"

    private val PREF_KEY_USER_EMAIL = "PREF_KEY_USER_USER_EMAIL"

    private val PREF_KEY_USER_TOKEN_EXPIRES = "PREF_KEY_USER_TOKEN_EXPIRES"

    val prefs : SharedPreferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)

    override var loggedInMode: Int
        get() = prefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
            LoggedInMode.LOGGED_OUT.type)
        set(value) {}

    override var email: String
        get() = prefs.getString(PREF_KEY_USER_EMAIL, "")!!
        set(value) {
            prefs.edit {
                putString(PREF_KEY_USER_EMAIL, value)
            }
        }

    override var expires: Long
        get() = prefs.getLong(PREF_KEY_USER_TOKEN_EXPIRES, 0)
        set(value) {
            prefs.edit {
                putLong(PREF_KEY_USER_TOKEN_EXPIRES, value)
            }
        }

    override fun setLoggedInMode(loggedInMode: LoggedInMode) {
        prefs.edit {
            putInt(PREF_KEY_USER_LOGGED_IN_MODE, loggedInMode.type)
        }
    }
}