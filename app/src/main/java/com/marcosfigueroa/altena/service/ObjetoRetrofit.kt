package com.marcosfigueroa.altena.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ObjetoRetrofit {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://heladosaltena.com/producto/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }

}