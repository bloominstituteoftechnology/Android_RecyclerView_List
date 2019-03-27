package com.example.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageDataViewHolder>{

    ArrayList<ImageData> imageData;

    Context context;

    public ImageListAdapter(ArrayList<ImageData> imageData){
        this.imageData = imageData;
    }

    class ImageDataViewHolder extends RecyclerView.ViewHolder{

        TextView imageNameView;
        ImageView imageView;
        View parentView;


        public ImageDataViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i("testone", "onBindViewHolder : called,");
            imageNameView = itemView.findViewById(R.id.image_name_text_view);
            imageView = itemView.findViewById(R.id.imageView);
            parentView = itemView.findViewById(R.id.list_parent);
        }
    }


    @NonNull
    @Override
    public ImageDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);
        Log.i("testone", "onBindViewHolder : called,");
        return new ImageDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageDataViewHolder viewHolder, int i) {
        final ImageData data = imageData.get(i);

        Log.i("testone", "onBindViewHolder : called,");

        viewHolder.imageView.setImageURI(Uri.parse(data.getUri()));
        viewHolder.imageNameView.setText(data.getName());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ImageDetails.class);
                intent.putExtra(ImageData.TAG, imageData);
                ((Activity)v.getContext()).startActivityForResult(intent,MainActivity.TO_DETAILS_REQUEST);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.imageData.size();
    }
}
