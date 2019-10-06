package com.sanmiaderibigbe.userauthentication.di.components

import android.app.Application
import com.sanmiaderibigbe.userauthentication.UserAuthenticationApplication
import com.sanmiaderibigbe.userauthentication.di.module.AppModule
import com.sanmiaderibigbe.userauthentication.di.module.NetworkModule
import com.sanmiaderibigbe.userauthentication.di.module.ActivityBuilderModule
import com.sanmiaderibigbe.userauthentication.di.module.ViewModelFactoryModule
import com.sanmiaderibigbe.userauthentication.di.qualifiers.sharedPreference
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class, NetworkModule::class, ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<UserAuthenticationApplication> {

    @Component.Builder
    interface  Builder {

        @BindsInstance
        fun  application(app: Application) : Builder
        @BindsInstance
        fun sharePrefrence(@sharedPreference name : String) : Builder

        fun build() : AppComponent

    }
}