package com.example.tiendaproyecto.ui.coment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tiendaproyecto.R
import com.example.tiendaproyecto.ui.activities.ComentListActivity
import com.example.tiendaproyecto.ui.activities.ListActivity
import kotlinx.android.synthetic.main.coment_row.view.*
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_row.view.ImageView
import com.example.tiendaproyecto.ui.coment.Comentario
import kotlin.coroutines.coroutineContext

class ComentAdapter(private val context: ComentListActivity): RecyclerView.Adapter<ComentAdapter.ComentViewHolder>(){

    private var dataList = mutableListOf<Comentario>()

    fun setListData(data:MutableList<Comentario>){
        dataList = data
    }
    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.coment_row,parent,false)
        return ComentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0) {
            dataList.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: ComentViewHolder, position: Int) {
        val coment: Comentario = dataList[position]
        holder.bindView(coment)
    }

    inner class ComentViewHolder(comentView: View): RecyclerView.ViewHolder(comentView){

        fun bindView(coment: Comentario){
            /*Glide.with(context).load(coment.imageprofile).into(itemView.ImageViewProfile)*/
            itemView.txt_id.text = coment.id
            itemView.txt_coment.text = coment.comenttext
        }
    }
}