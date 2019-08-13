package com.example.imageviewer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_item_layout.view.*

class ImageListAdapter (val data: ArrayList<ImageData>) :
    RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.image_view
        val imageName: TextView = view.image_name
        val imageUri: TextView = view.image_uri

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageURI(data[position].fileUri)
        holder.imageName.text=  data[position].fileName
        holder.imageUri.text= data[position].fileUriString
        //holder.itemView.Set



    }
}

