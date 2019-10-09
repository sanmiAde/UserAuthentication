package com.sanmiaderibigbe.userauthentication

import com.sanmiaderibigbe.userauthentication.di.components.DaggerAppComponent
import com.sanmiaderibigbe.userauthentication.utils.AppConstants
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class UserAuthenticationApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent
            .builder()
            .sharePrefrence(AppConstants.PREF_NAME)
            .application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}
