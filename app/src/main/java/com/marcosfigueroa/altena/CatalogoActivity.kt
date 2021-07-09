package com.marcosfigueroa.altena

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcosfigueroa.altena.adapters.CatalogoAdapter
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

        binding.recyclerCatalogo.layoutManager = LinearLayoutManager(this)
        val viewModelCatalogo = ViewModelProvider(this).get(ViewModelCatalogo::class.java)

        val adapter = CatalogoAdapter()
        binding.recyclerCatalogo.adapter = adapter

        viewModelCatalogo.catalogoList.observe(this, Observer { catalogoList ->
            adapter.submitList(catalogoList)
        })

        adapter.onItemClickListener = {
            Toast.makeText(this, it.nombre_producto, Toast.LENGTH_SHORT).show()
        }

    }


}