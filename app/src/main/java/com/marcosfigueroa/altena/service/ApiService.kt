package com.marcosfigueroa.altena.service

import com.marcosfigueroa.altena.models.Data
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("consultar")
    suspend fun getCatalogos(): Data
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://heladosaltena.com/producto/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

var service: ApiService = retrofit.create(ApiService::class.java)