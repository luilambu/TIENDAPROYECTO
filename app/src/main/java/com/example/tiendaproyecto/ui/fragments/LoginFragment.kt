package com.example.tiendaproyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tiendaproyecto.databinding.FragmentLoginBinding
import android.widget.Toast

import com.example.tiendaproyecto.ui.activities.MainActivity
import com.firebase.ui.auth.AuthUI.getApplicationContext


class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentLoginBinding? = null
    private val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//                return inflater.inflate(R.layout.fragment_login, container, false)
        _binding = FragmentLoginBinding.inflate(inflater,container,false)

        return binding.root
    }

}