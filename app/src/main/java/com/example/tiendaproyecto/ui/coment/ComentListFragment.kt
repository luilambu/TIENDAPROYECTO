/*package com.example.tiendaproyecto.ui.coment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.tiendaproyecto.R
import com.example.tiendaproyecto.ui.coment.ComentAdapter
import com.example.tiendaproyecto.ui.coment.ComentViewModel
import com.example.tiendaproyecto.ui.coment.Comentario
import kotlinx.android.synthetic.main.fragment_coment_list.*


class ComentListFragment: Fragment() {
    private lateinit var adapter: ComentAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(ComentViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ComentAdapter(this)
        recyclerViewComent.layoutManager = LinearLayoutManager(this)
        recyclerViewComent.adapter = adapter
        observeData()
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    fun observeData(){
        shimmer_view_container.startShimmer()
        viewModel.fetchComentData().observe(this, Observer {
            shimmer_view_container.hideShimmer()
            shimmer_view_container.stopShimmer()
            shimmer_view_container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}*/