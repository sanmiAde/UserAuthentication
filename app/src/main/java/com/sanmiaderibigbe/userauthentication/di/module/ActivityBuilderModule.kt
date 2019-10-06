package com.sanmiaderibigbe.userauthentication.di.module

import com.sanmiaderibigbe.userauthentication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun  mainActivity() : MainActivity


}