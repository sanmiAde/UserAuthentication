package com.sanmiaderibigbe.userauthentication.di.module

import com.sanmiaderibigbe.userauthentication.di.scope.MainActivityScope
import com.sanmiaderibigbe.userauthentication.ui.login.LoginFragment
import com.sanmiaderibigbe.userauthentication.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @MainActivityScope
    @ContributesAndroidInjector(modules = [HomeFragmentBuilder::class, LoginFragmentBuilder::class, LoginRepoModule::class])
    abstract fun  mainActivity() : MainActivity
}