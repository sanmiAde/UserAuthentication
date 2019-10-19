package com.sanmiaderibigbe.userauthentication.di.module

import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.ui.signup.ISignUpRepository
import com.sanmiaderibigbe.userauthentication.ui.signup.SignUpRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
class SignUpRepoModule {

    @Provides
    fun provideRepo(
        apiInterface: ApiInterface,
        sharedPreferences: SharedPreferences,
        moshi: Moshi
    ): ISignUpRepository {
        return SignUpRepository(apiInterface, sharedPreferences, moshi)
    }
}