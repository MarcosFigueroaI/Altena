package com.marcosfigueroa.altena.service

import com.marcosfigueroa.altena.models.Data
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("consultar")
    suspend fun getCatalogos(): Data

}