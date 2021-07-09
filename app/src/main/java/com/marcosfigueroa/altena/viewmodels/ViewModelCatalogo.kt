package com.marcosfigueroa.altena.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosfigueroa.altena.models.Catalogo
import com.marcosfigueroa.altena.models.Data
import com.marcosfigueroa.altena.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelCatalogo: ViewModel() {

    private var _catalogoList = MutableLiveData<MutableList<Catalogo>>()
    val catalogoList: LiveData<MutableList<Catalogo>>
        get() = _catalogoList

    private val repository = Repository()

    init {
        viewModelScope.launch {
            _catalogoList.value = repository.fetchCatalogos()
        }
    }

}