package com.marcosfigueroa.altena.repository

import com.marcosfigueroa.altena.models.Data
import com.marcosfigueroa.altena.service.ObjetoRetrofit
import retrofit2.Response

class Repository {

    suspend fun getCatalogos(): Response<Data> {
        return ObjetoRetrofit.api.getCatalogos()
    }

}