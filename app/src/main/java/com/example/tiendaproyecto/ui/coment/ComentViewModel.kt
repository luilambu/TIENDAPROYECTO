package com.example.tiendaproyecto.ui.coment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tiendaproyecto.Producto
import com.example.tiendaproyecto.Repo

class ComentViewModel: ViewModel() {

    private val repo = Repo()
    fun fetchComentData():LiveData<MutableList<Comentario>>{
        val mutableData = MutableLiveData<MutableList<Comentario>>()
        repo.getComentData().observeForever{ comentList ->
            mutableData.value = comentList
        }

        return mutableData
    }
}