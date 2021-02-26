package com.mobile.ecommercemymall.Network

import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResponseUsers
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET


//todo 2.1 Config API
interface ConfigApi {

    @GET("selectProduct.php")
    fun selectProduct(
    ): Flowable<ResponseProducts>

    @GET("selectUsers.php")
    fun selectUsers(
    ): Flowable<ResponseUsers>
}