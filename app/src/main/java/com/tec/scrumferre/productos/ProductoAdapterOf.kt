package com.tec.scrumferre.productos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tec.scrumferre.R
import com.tec.scrumferre.usuarios

class ProductoAdapterOf(private var productos: List<usuarios.ProductoOf> = emptyList()) :
    RecyclerView.Adapter<ProductoAdapterOf.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto_of, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentItem = productos[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = productos.size

    fun submitList(list: List<usuarios.ProductoOf>) {
        productos = list
        notifyDataSetChanged()
    }

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id: TextView = itemView.findViewById(R.id.txv_ID_PRO)
        private val nombre: TextView = itemView.findViewById(R.id.txv_Nombre)
        private val descripcion: TextView = itemView.findViewById(R.id.txv_Descripcion)
        private val stock: TextView = itemView.findViewById(R.id.txv_Stock)
        private val precio: TextView = itemView.findViewById(R.id.txv_Precio)

        fun bind(producto: usuarios.ProductoOf) {
            nombre.text = producto.Nombre
            id.text = producto.ID_PRO.toString()
            descripcion.text = producto.Descripcion.toString()
            stock.text = producto.Stock.toString()
            precio.text = producto.Precio.toString()
        }
    }
}
