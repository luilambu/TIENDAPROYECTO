package com.example.tiendaproyecto.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tiendaproyecto.Producto
import com.example.tiendaproyecto.Repo

class ListViewModel: ViewModel() {

    private val repo = Repo()
    fun fetchProductData():LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        repo.getProductData().observeForever{ productList ->
            mutableData.value = productList
        }

        return mutableData
    }
}