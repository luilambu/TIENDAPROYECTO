package com.example.tiendaproyecto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.example.tiendaproyecto.Producto

class Repo {

    fun getProductData():LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        FirebaseFirestore.getInstance().collection("Productos").get().addOnSuccessListener { result ->
            val listData: MutableList<Producto> = mutableListOf<Producto>()
            for (document: QueryDocumentSnapshot in result){
                val imageUrl: String? = document.getString("imageUrl")
                val nombre: String? = document.getString("nombre")
                val descripcion: String? = document.getString("descripcion")
                val precio: String? = document.getString("precio")
                val producto = Producto(imageUrl!!,nombre!!,descripcion!!,precio!!)
                listData.add(producto)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}