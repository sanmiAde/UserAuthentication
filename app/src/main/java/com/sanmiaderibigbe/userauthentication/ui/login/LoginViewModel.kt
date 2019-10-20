package com.sanmiaderibigbe.userauthentication.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.remote.SignInResult
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import com.sanmiaderibigbe.userauthentication.utils.SharedPrefUtils
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val loginRepository: ILoginRepository,
    val sharedPreferences: SharedPreferences,
    val moshi: Moshi
) : ViewModel() {
    private val  userLoginStatusLivedata = MutableLiveData<Boolean>()
    private val _loginResponseLiveData = MutableLiveData<SignInResult>()
    private val compositeDisposable = CompositeDisposable()
    val loginResponseLiveData: LiveData<SignInResult>
        get() = _loginResponseLiveData

    init {

        Timber.d("IUser login status : ${userLoginStatusLivedata.value.toString()}")
    }

    fun getLoginStatus() : LiveData<Boolean> {
        userLoginStatusLivedata.value = loginRepository.isUserLoggedIn()
        return userLoginStatusLivedata
    }

    fun logOutUser() {
        loginRepository.logOut()
        userLoginStatusLivedata.value = loginRepository.isUserLoggedIn()
    }

    fun logInUser(email: String, password: String) {
        compositeDisposable.add(
            loginRepository.login(
                email,
                password
            ).observeOn(AndroidSchedulers.mainThread()).subscribe({
                _loginResponseLiveData.value = SignInResult.Success(true)
                SharedPrefUtils.saveUserToSharePref(
                    SignInResponseModel(it.msg, it.tokenPair),
                    email,
                    LoggedInMode.LOGGED_IN,
                    sharedPreferences,
                    moshi
                ).subscribe {
                    userLoginStatusLivedata.value = loginRepository.isUserLoggedIn()
                }

            }, {
                _loginResponseLiveData.value = SignInResult.Error(false, it.localizedMessage)
            })
        )
    }
}
