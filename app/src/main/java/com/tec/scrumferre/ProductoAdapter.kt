package com.tec.scrumferre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(private var productos: List<usuarios.Producto> = emptyList()) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentItem = productos[position]
        holder.textViewNombre.text = currentItem.Nombre
        holder.textViewDescripcion.text = currentItem.Descripcion
        holder.textViewPrecio.text = currentItem.Precio.toString()
        holder.textViewStock.text = currentItem.Stock.toString()
    }

    override fun getItemCount() = productos.size
    fun submitList(list: List<usuarios.Producto>) {
       productos = list
        notifyDataSetChanged()

    }


    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDescripcion: TextView = itemView.findViewById(R.id.textViewDescripcion)
        val textViewPrecio: TextView = itemView.findViewById(R.id.textViewPrecio)
        val textViewStock: TextView = itemView.findViewById(R.id.textViewStock)
    }
}
