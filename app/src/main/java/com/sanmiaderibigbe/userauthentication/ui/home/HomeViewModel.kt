package com.sanmiaderibigbe.userauthentication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanmiaderibigbe.userauthentication.data.local.UserDataModel
import com.sanmiaderibigbe.userauthentication.data.remote.GetDataResult
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _userDataLiveData = MutableLiveData<GetDataResult>()


    val userDataLiveData: MutableLiveData<GetDataResult>
        get() = _userDataLiveData



    fun getUserData(): UserCredentialsData {
        return repository.getUserData()
    }

    fun getUserId(header: String, email: String) {
        compositeDisposable.add(
            repository.getUserId(
                header,
                email
            ).observeOn(AndroidSchedulers.mainThread()).subscribe({
                if (it.isSuccessful) {
                    Timber.d(it.body()?.userId)
                    _userDataLiveData.value =
                        GetDataResult.Success(UserDataModel(it.body()?.email, it.body()?.userId))
                } else {
                    _userDataLiveData.value = GetDataResult.Error(it.message())
                }

            }, {
                _userDataLiveData.value = GetDataResult.Error(it.localizedMessage)
            })
        )
    }


}
