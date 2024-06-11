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
        holder.bind(currentItem)
    }

    override fun getItemCount() = productos.size

    fun submitList(list: List<usuarios.Producto>) {
        productos = list
        notifyDataSetChanged()
    }

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        private val textViewApellido: TextView = itemView.findViewById(R.id.textViewApellido)
        private val textViewCorreo: TextView = itemView.findViewById(R.id.textViewCorreo)
        private val textViewContrasena: TextView = itemView.findViewById(R.id.textViewContrasena)
        private val textViewTelefono: TextView = itemView.findViewById(R.id.textViewTelefono)
        private val textViewDireccion: TextView = itemView.findViewById(R.id.textViewDireccion)
        private val textViewTipoUsuario: TextView = itemView.findViewById(R.id.textViewTipoUsuario)

        fun bind(producto: usuarios.Producto) {
            textViewNombre.text = producto.Nombre
            textViewApellido.text = producto.Apellido
            textViewCorreo.text = producto.Correo
            textViewTelefono.text = producto.telefono
            textViewDireccion.text = producto.direccion
            textViewTipoUsuario.text = producto.tipoUsuario
        }
    }
}
