package com.sanmiaderibigbe.userauthentication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(val loginRepository: ILoginRepository) : ViewModel() {
    private val  userLoginStatusLivedata = MutableLiveData<Boolean>()

    init {

        Timber.d("IUser login status : ${userLoginStatusLivedata.value.toString()}")
    }

    fun getLoginStatus() : LiveData<Boolean> {
        userLoginStatusLivedata.value = loginRepository.isUserLoggedIn()
        return userLoginStatusLivedata
    }
}
