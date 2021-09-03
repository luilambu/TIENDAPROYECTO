/*package com.example.tiendaproyecto.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendaproyecto.databinding.FragmentListBinding
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tiendaproyecto.ui.fragments.ListAdapter
import com.example.tiendaproyecto.ui.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentListBinding? = null
    private val binding get() =  _binding!!

    private lateinit var adapter: ListAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(ListViewModel::class.java)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): ConstraintLayout {
        super.onCreate(savedInstanceState)
        //this.supportActionBar?.hide()
        //setContentView(R.layout.fragment_list)

       // adapter = ListAdapter(this)
        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData()

        _binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
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
    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//                return inflater.inflate(R.layout.fragment_login, container, false)
        _binding = FragmentListBinding.inflate(inflater,container,false)

    }*/
}*/