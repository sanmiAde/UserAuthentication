package com.sanmiaderibigbe.userauthentication.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.di.qualifiers.SharedPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun sharedPreference(application: Application, @SharedPreference name : String): SharedPreferences {
        return application.getSharedPreferences(name, Context.MODE_PRIVATE)
    }
}