package com.thadocizn.imageviewer.classes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thadocizn.imageviewer.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {


    ArrayList<ImageData> imageList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtTitle;
        public ImageView imgPicture;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = view.findViewById(R.id.tvTitle);
            imgPicture = view.findViewById(R.id.ivPicture);
        }
    }

    public ImageAdapter(ArrayList<ImageData> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ImageData imageData = imageList.get(i);
        myViewHolder.txtTitle.setText(imageData.getName());
        myViewHolder.imgPicture.setImageURI(imageData.getUri());
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

}
