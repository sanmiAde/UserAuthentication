package com.sanmiaderibigbe.userauthentication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanmiaderibigbe.userauthentication.data.local.UserDataModel
import com.sanmiaderibigbe.userauthentication.data.remote.GetDataResult
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
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

                    _userDataLiveData.value =
                        GetDataResult.Success(UserDataModel(it?.email, it?.userId))

            }, {
                _userDataLiveData.value = GetDataResult.Error(it.localizedMessage)
            })
        )
    }


}
