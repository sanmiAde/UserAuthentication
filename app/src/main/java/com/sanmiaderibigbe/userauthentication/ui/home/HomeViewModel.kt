package com.sanmiaderibigbe.userauthentication.ui.home

import androidx.lifecycle.ViewModel
import com.sanmiaderibigbe.userauthentication.data.local.SignInResponseModel
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {

    fun getUserData(): UserCredentialsData {
        return repository.getUserData()
    }
}
