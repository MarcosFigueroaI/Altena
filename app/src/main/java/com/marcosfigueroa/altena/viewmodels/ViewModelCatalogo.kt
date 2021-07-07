package com.marcosfigueroa.altena.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosfigueroa.altena.models.Data
import com.marcosfigueroa.altena.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelCatalogo(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Data>> = MutableLiveData()

    fun getCatalogos() {
        viewModelScope.launch {
            val response = repository.getCatalogos()
            myResponse.value = response
        }
    }

}