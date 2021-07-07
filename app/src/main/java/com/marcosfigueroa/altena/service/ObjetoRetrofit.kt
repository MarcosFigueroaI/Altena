package com.marcosfigueroa.altena.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ObjetoRetrofit {

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttp = OkHttpClient.Builder().addInterceptor(logger)

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://heladosaltena.com/producto/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()
    }

    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }

}