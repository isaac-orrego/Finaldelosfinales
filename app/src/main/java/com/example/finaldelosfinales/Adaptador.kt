package com.example.finaldelosfinales

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.finaldelosfinales.R
import com.squareup.picasso.Picasso

class Adaptador (val images: List<String>) : RecyclerView.Adapter<Adaptador.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.itemperro, parent, false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(image: String) {
            var imagenPerro = itemView.findViewById(R.id.imageView) as ImageView
            imagenPerro.from(image)
        }

        fun ImageView.from(url:String){
            Picasso.get().load(url).resize(400,400).centerCrop().into(this)


        }
    }
}