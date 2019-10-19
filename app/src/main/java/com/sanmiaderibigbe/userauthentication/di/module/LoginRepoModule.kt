package com.sanmiaderibigbe.userauthentication.di.module

import android.app.Application
import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.data.sharedPref.AppPreferenceHelper
import com.sanmiaderibigbe.userauthentication.data.sharedPref.PreferencesHelper
import com.sanmiaderibigbe.userauthentication.ui.login.ILoginRepository
import com.sanmiaderibigbe.userauthentication.ui.login.LoginRepository
import dagger.Module
import dagger.Provides

@Module
class LoginRepoModule {

    @Provides
    fun provideRepo(
        apiInterface: ApiInterface,
        appPreferenceHelper: PreferencesHelper,
        sharedPreferences: SharedPreferences
    ): ILoginRepository {
        return LoginRepository(apiInterface, appPreferenceHelper, sharedPreferences)
    }

    @Provides
    fun provideAppPreference(context: Application) : PreferencesHelper{
        return AppPreferenceHelper(context)
    }

}