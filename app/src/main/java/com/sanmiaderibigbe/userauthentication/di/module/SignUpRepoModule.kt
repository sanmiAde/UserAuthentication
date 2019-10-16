package com.sanmiaderibigbe.userauthentication.di.module

import com.sanmiaderibigbe.userauthentication.data.remote.ApiInterface
import com.sanmiaderibigbe.userauthentication.ui.signup.ISignUpRepository
import com.sanmiaderibigbe.userauthentication.ui.signup.SignUpRepository
import dagger.Module
import dagger.Provides

@Module
class SignUpRepoModule {

    @Provides
    fun provideRepo(apiInterface: ApiInterface): ISignUpRepository {
        return SignUpRepository(apiInterface)
    }
}