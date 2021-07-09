package com.marcosfigueroa.altena.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marcosfigueroa.altena.databinding.ItemCatalogoBinding
import com.marcosfigueroa.altena.models.Catalogo

private val TAG = CatalogoAdapter::class.java.simpleName

class CatalogoAdapter : ListAdapter<Catalogo, CatalogoAdapter.MyViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Catalogo>() {
        override fun areItemsTheSame(oldItem: Catalogo, newItem: Catalogo): Boolean {
            return oldItem.cve_producto == newItem.cve_producto
        }

        override fun areContentsTheSame(oldItem: Catalogo, newItem: Catalogo): Boolean {
           return oldItem == newItem
        }

    }

    lateinit var onItemClickListener: (Catalogo) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogoAdapter.MyViewHolder {
        val binding = ItemCatalogoBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogoAdapter.MyViewHolder, position: Int) {
        val catalogo = getItem(position)
        holder.bind(catalogo)
    }

    inner class MyViewHolder(private val binding: ItemCatalogoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogo: Catalogo) {
            binding.catalogoText.text = catalogo.nombre_producto
            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(catalogo)
                } else {
                    Log.e(TAG, "onItemClickListener not initialized")
                }
            }
        }
    }
}