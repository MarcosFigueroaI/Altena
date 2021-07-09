package com.marcosfigueroa.altena.repository

import com.marcosfigueroa.altena.models.Catalogo
import com.marcosfigueroa.altena.models.Data
import com.marcosfigueroa.altena.service.ObjetoRetrofit
import com.marcosfigueroa.altena.service.service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository {

    suspend fun fetchCatalogos(): MutableList<Catalogo> {
        return withContext(Dispatchers.IO) {
            val catalogoJsonResponse = service.getCatalogos()
            val catalogoList = parseResult(catalogoJsonResponse)

            catalogoList
        }
    }

    private fun parseResult(catalogoJsonResponse: Data): MutableList<Catalogo> {
        val catalogoList = mutableListOf<Catalogo>()
        val arrayDatos = catalogoJsonResponse.arrayDatos

        for (i in arrayDatos) {
            val cveProducto = i.cve_producto
            val nombreProducto = i.nombre_producto

            catalogoList.add(Catalogo(cveProducto, nombreProducto))
        }

        return catalogoList
    }

}