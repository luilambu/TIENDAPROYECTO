package com.example.tiendaproyecto.ui.coment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tiendaproyecto.Repo
import com.example.tiendaproyecto.databinding.FragmentComentBinding
import com.example.tiendaproyecto.databinding.FragmentLoginBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_coment.*
import java.security.Provider
import android.widget.Toast.makeText as toastMakeText

class ComentFragment : Fragment() {

    private lateinit var comentViewModel: ComentViewModel
    private var _binding: FragmentComentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val db= FirebaseFirestore.getInstance()

    override fun onStart() {
        super.onStart()
        Comentbutton.setOnClickListener{
            //val provider = "Repo"
            db.collection("Coments").document().set(
                hashMapOf(
                "id" to editTextTextPersonName.text.toString(),
                "comentario" to editTextTextComent.text.toString())
            )
            editTextTextComent.setText("")
            editTextTextPersonName.setText("")

            //confirmacion de escritura no funciona?

            val builder= AlertDialog.Builder(context)
            builder.setTitle("Comentado")
            builder.setPositiveButton("Continuar") {dialog , which ->
                Toast.makeText(context,"listo",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//                return inflater.inflate(R.layout.fragment_login, container, false)
        _binding = FragmentComentBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


