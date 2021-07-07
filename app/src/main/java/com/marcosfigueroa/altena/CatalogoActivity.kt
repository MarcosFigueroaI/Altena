package com.marcosfigueroa.altena

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.marcosfigueroa.altena.databinding.ActivityCatalogoBinding
import com.marcosfigueroa.altena.models.Catalogo
import com.marcosfigueroa.altena.repository.Repository
import com.marcosfigueroa.altena.viewmodels.ViewModelCatalogo

class CatalogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatalogoBinding
    private lateinit var viewModelCatalogo: ViewModelCatalogo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModelCatalogo = ViewModelProvider(this, viewModelFactory).get(ViewModelCatalogo::class.java)
        viewModelCatalogo.getCatalogos()
        viewModelCatalogo.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {

            }
        })

    }
}