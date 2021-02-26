package com.mobile.ecommercemymall.Network

import com.mobile.inkadosumbar.Constants.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//todo 1.1 Config network
class ConfigNetwork {
    companion object {
        fun getRetrofit(): ConfigApi {
            val builder = OkHttpClient.Builder()
            builder.readTimeout(100, TimeUnit.SECONDS)
            builder.connectTimeout(100, TimeUnit.SECONDS)
            builder.writeTimeout(100, TimeUnit.SECONDS)

            val client = builder.build()
            var constants: Constants?=null
            constants = Constants()

            val retrofit = Retrofit.Builder()
                .baseUrl(constants?.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigApi::class.java)

            return service
        }
    }
}