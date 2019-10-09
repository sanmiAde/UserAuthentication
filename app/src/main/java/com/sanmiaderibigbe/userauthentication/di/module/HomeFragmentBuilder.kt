package com.sanmiaderibigbe.userauthentication.di.module

import com.sanmiaderibigbe.userauthentication.di.scope.HomeFragmentScope
import com.sanmiaderibigbe.userauthentication.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuilder {

    @ContributesAndroidInjector

    abstract fun homeFragment() : HomeFragment
}