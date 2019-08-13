package com.example.recyclerviewlist2.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlist2.R
import com.example.recyclerviewlist2.model.Imagedata
import kotlinx.android.synthetic.main.image_item_layout.view.*


class ImageListAdapter (val Image_data: MutableList<Imagedata>):
    RecyclerView.Adapter<ImageListAdapter.ViewHolder>(){

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.Picture_image
        val description: TextView = view.Picture_Description
        val name: TextView = view.Picture_Name



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout,parent, false)
        return ViewHolder(viewGroup)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.description.text = Image_data[position].description
        holder.image.setImageDrawable(Image_data[position].image)
        holder.name.text = Image_data[position].name
    }

    override fun getItemCount(): Int {
        return Image_data.size
    }
}
