package com.sanmiaderibigbe.userauthentication.di.module

import android.app.Application
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
    fun provideRepo(apiInterface: ApiInterface, appPreferenceHelper: PreferencesHelper) : ILoginRepository {
        return  LoginRepository( apiInterface, appPreferenceHelper )
    }

    @Provides
    fun provideAppPreference(context: Application) : PreferencesHelper{
        return AppPreferenceHelper(context)
    }

}