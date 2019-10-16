package com.sanmiaderibigbe.userauthentication.data.sharedPref

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.sanmiaderibigbe.userauthentication.utils.AppConstants
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(private val context: Application) :
    PreferencesHelper {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)

    override var userId: String
        get() = prefs.getString(PREF_KEY_USER_ID, "")!!
        set(value) {
            prefs.edit {
                putString(PREF_KEY_USER_ID, value)
            }
        }
    override var accessToken: String
        get() = prefs.getString(PREF_KEY_ACCESS_TOKEN, "")!!
        set(value) {
            prefs.edit {
                putString(PREF_KEY_ACCESS_TOKEN, value)
            }
        }

    override var refreshToken: String
        get() = prefs.getString(PREF_KEY_REFRESH_TOKEN, "")!!
        set(value) {
            prefs.edit {
                putString(PREF_KEY_REFRESH_TOKEN, value)
            }
        }

    override var loggedInMode: Int
        get() =
            prefs.getInt(
                Companion.PREF_KEY_USER_LOGGED_IN_MODE,
                LoggedInMode.LOGGED_OUT.type
            )
        set(value) {
            prefs.edit {
                putInt(Companion.PREF_KEY_USER_LOGGED_IN_MODE, loggedInMode)
            }
        }

    override var email: String
        get() = prefs.getString(Companion.PREF_KEY_USER_EMAIL, "")!!
        set(value) {
            prefs.edit {
                putString(Companion.PREF_KEY_USER_EMAIL, value)
            }
        }

    override var expires: Long
        get() = prefs.getLong(Companion.PREF_KEY_USER_TOKEN_EXPIRES, 0)
        set(value) {
            prefs.edit {
                putLong(Companion.PREF_KEY_USER_TOKEN_EXPIRES, value)
            }
        }


    companion object {
        private const val PREF_KEY_USER_TOKEN_EXPIRES = "PREF_KEY_USER_TOKEN_EXPIRES"
        private const val PREF_KEY_USER_EMAIL = "PREF_KEY_USER_USER_EMAIL"
        private const val PREF_KEY_REFRESH_TOKEN = "PREF_KEY_REFRESH_TOKEN"
        const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private const val PREF_KEY_USER_ID = "PREF_KEY_USER_ID"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }
}