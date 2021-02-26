package com.mobile.ecommercemymall.Repository

import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResponseUsers
import com.mobile.ecommercemymall.Network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    // todo 1 Konfigurasi repository
    fun getProducts(
        reponseHandler: (ResponseProducts) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().selectProduct()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                reponseHandler(response)
            }, { t ->
                errorHandler(t)
            })
    }

    fun getUsers(
        reponseHandler: (ResponseUsers) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().selectUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                reponseHandler(response)
            }, { t ->
                errorHandler(t)
            })
    }
}