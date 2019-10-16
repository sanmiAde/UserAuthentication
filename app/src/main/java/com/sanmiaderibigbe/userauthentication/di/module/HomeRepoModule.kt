package com.sanmiaderibigbe.userauthentication.di.module

import android.content.SharedPreferences
import com.sanmiaderibigbe.userauthentication.ui.home.IRepository
import com.sanmiaderibigbe.userauthentication.ui.home.Repository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
class HomeRepoModule {
    @Provides
    fun provideRepo(sharedPreferences: SharedPreferences, moshi: Moshi): IRepository {
        return Repository(sharedPreferences, moshi)
    }
}