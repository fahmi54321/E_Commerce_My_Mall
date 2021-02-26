package com.mobile.ecommercemymall.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResponseUsers
import com.mobile.ecommercemymall.Repository.Repository

class ViewModel:ViewModel() {

    // todo 2 inisiaslisasi repository
    val repository = Repository()

    //select product
    var responProducts = MutableLiveData<ResponseProducts>()
    var errorProducts = MutableLiveData<Throwable>()
    var showLoadingProduct = MutableLiveData<Boolean>()

    //select user
    var responUsers = MutableLiveData<ResponseUsers>()
    var errorUsers = MutableLiveData<Throwable>()
    var showLoadingUsers = MutableLiveData<Boolean>()

    // todo 4 membuat fungsi yang diperlukan
    fun getProduct(
    ) {
        showLoadingProduct.value = true
        repository.getProducts({
            responProducts.value = it
            showLoadingProduct.value = false
        }) {
            errorProducts.value = it
            showLoadingProduct.value = false
        }
    }

    fun getUsers(
    ) {
        showLoadingUsers.value = true
        repository.getUsers({
            responUsers.value = it
            showLoadingUsers.value = false
        }) {
            errorUsers.value = it
            showLoadingUsers.value = false
        }
    }
}