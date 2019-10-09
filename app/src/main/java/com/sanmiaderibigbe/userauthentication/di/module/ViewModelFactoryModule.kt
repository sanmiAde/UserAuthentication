package com.sanmiaderibigbe.userauthentication.di.module

import androidx.lifecycle.ViewModelProvider
import com.sanmiaderibigbe.userauthentication.di.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @Singleton
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory<*>): ViewModelProvider.Factory
}