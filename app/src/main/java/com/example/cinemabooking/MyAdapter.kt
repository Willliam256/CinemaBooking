package com.example.cinemabooking

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val arrayList:ArrayList<MovieData>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //set a local variable of type onItemClickListener that will act as the the object of the interface
    private lateinit var mylistener:OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mylistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.movie_row_layout, parent, false)
        return MyViewHolder(layoutInflater, mylistener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currItem = arrayList[position]
        holder.image.setImageResource(currItem.image)
        holder.title.text = currItem.movieTitle
        holder.subtitle.text = currItem.movieSubtitle

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyViewHolder(private val itemView:View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.profile_image)
        val title:TextView = itemView.findViewById(R.id.movie_title)
        val subtitle:TextView = itemView.findViewById(R.id.movie_subtitle)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }


}