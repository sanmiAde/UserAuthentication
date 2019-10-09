package com.sanmiaderibigbe.userauthentication.di.module

import com.sanmiaderibigbe.userauthentication.di.scope.LoginFragmentScope
import com.sanmiaderibigbe.userauthentication.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentBuilder{

    @ContributesAndroidInjector

    abstract fun loginFragment() : LoginFragment
}