package com.sanmiaderibigbe.userauthentication.di.module

import com.sanmiaderibigbe.userauthentication.ui.signup.SignupFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignUpFragmentModule {

    @ContributesAndroidInjector(modules = [SignUpRepoModule::class])
    abstract fun signUpFragment(): SignupFragment
}