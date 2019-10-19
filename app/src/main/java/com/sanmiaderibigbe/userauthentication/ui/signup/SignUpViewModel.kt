package com.sanmiaderibigbe.userauthentication.ui.signup

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpResult
import com.sanmiaderibigbe.userauthentication.data.sharedPref.LoggedInMode
import com.sanmiaderibigbe.userauthentication.utils.SharedPrefUtils
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import timber.log.Timber
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val signUpRepository: ISignUpRepository,
    private val sharedPreferences: SharedPreferences,
    private val moshi: Moshi
) : ViewModel() {

    private val _signUpSuccessful = MutableLiveData<SignUpResult>()
    private val compositeDisposable = CompositeDisposable()

    val signUpSuccessful: LiveData<SignUpResult>
        get() {
            return _signUpSuccessful
        }


    fun signUp(email: String, password: String) {
        compositeDisposable.add(
            signUpRepository.signUp(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d(it.tokenPair.accessToken)
                    signUpRepository.saveUSerData(
                        SignInResponseModel(it.msg, it.tokenPair),
                        email,
                        LoggedInMode.LOGGED_IN
                    ).subscribe {
                        _signUpSuccessful.value = SignUpResult.Success(true)
                    }

                }, {
                    Timber.d(it.localizedMessage)
                    _signUpSuccessful.value = SignUpResult.Error(false, it.localizedMessage!!)
                })
        )

    }
}