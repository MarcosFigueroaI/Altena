package com.marcosfigueroa.altena

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marcosfigueroa.altena.repository.Repository
import com.marcosfigueroa.altena.viewmodels.ViewModelCatalogo

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelCatalogo(repository) as T
    }

}