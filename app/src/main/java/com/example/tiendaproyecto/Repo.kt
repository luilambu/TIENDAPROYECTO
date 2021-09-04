package com.example.tiendaproyecto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.example.tiendaproyecto.Producto
import com.example.tiendaproyecto.ui.coment.Comentario

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
    fun getComentData():LiveData<MutableList<Comentario>>{
        val mutableData = MutableLiveData<MutableList<Comentario>>()
        FirebaseFirestore.getInstance().collection("Coments").get().addOnSuccessListener { result ->
            val comentData: MutableList<Comentario> = mutableListOf<Comentario>()
            for (document: QueryDocumentSnapshot in result){
                //val imageUrl: String? = document.getString("imageUrl")
                val id: String? = document.getString("id")
                val coment: String? = document.getString("comentario")
                val comentario = Comentario(/*imageUrl!!,*/id!!,coment!!)
                comentData.add(comentario)
            }
            mutableData.value = comentData
        }
        return mutableData
    }
}