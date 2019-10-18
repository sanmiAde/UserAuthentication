package com.sanmiaderibigbe.userauthentication.data.remote

import com.sanmiaderibigbe.userauthentication.data.local.UserDataModel

sealed class GetDataResult {
    object Loading : GetDataResult()
    data class Success(val result: UserDataModel) : GetDataResult()
    data class Error(val errorMessage: String) : GetDataResult()
}
