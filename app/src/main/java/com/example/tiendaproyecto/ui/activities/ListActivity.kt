package com.example.tiendaproyecto.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendaproyecto.ui.fragments.ListAdapter
import com.example.tiendaproyecto.ui.viewmodel.ListViewModel
import com.example.tiendaproyecto.R
import kotlinx.android.synthetic.main.fragment_list.*

class ListActivity: AppCompatActivity() {
    private lateinit var adapter: ListAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(ListViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.fragment_list)

        adapter = ListAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData()
    }
    fun observeData(){
        shimmer_view_container.startShimmer()
        viewModel.fetchProductData().observe(this, Observer {
            shimmer_view_container.hideShimmer()
            shimmer_view_container.stopShimmer()
            shimmer_view_container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}