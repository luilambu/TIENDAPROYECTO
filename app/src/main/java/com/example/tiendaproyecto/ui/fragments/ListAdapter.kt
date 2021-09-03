package com.example.tiendaproyecto.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tiendaproyecto.Producto
import com.example.tiendaproyecto.R
import com.example.tiendaproyecto.ui.activities.ListActivity
import kotlinx.android.synthetic.main.item_row.view.*

class ListAdapter(private val context: ListActivity): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    private var dataList = mutableListOf<Producto>()

    fun setListData(data:MutableList<Producto>){
        dataList = data
    }
    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0) {
            dataList.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val producto: Producto = dataList[position]
        holder.bindView(producto)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(producto: Producto){
            Glide.with(context).load(producto.imageUrl).into(itemView.ImageView)
            itemView.txt_title.text = producto.nombre
            itemView.txt_desc.text = producto.descripcion
            itemView.txt_price.text = producto.precio
        }
    }
}
