package com.tec.scrumferre

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tec.scrumferre.databinding.ActivityMainBinding
import com.tec.scrumferre.databinding.ActivityMainProductosBinding
import com.tec.scrumferre.productos.ProductService
import com.tec.scrumferre.productos.ProductoAdapterOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityProductos : AppCompatActivity() {
    private lateinit var service: ProductService
    private lateinit var adapter: ProductoAdapterOf
    private  lateinit var binding: ActivityMainProductosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
        setupRecyclerView()
        setupRetrofit()
        getProductos()

    }

    private fun getProductos() {
        lifecycleScope.launch(Dispatchers.IO) {

            // Realizar la llamada al servicio para obtener la lista de usuarios
            val usuarios = service.getProducto()
            Log.i("sms", usuarios.toString())
            withContext(Dispatchers.Main){
                adapter.submitList(usuarios)
            }

        }
    }

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants. BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        service = retrofit.create(ProductService::class.java)
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(  3, RecyclerView.VERTICAL)
            adapter = this@MainActivityProductos.adapter}
    }


    private fun setupAdapter() {
        adapter = ProductoAdapterOf()


    }








}