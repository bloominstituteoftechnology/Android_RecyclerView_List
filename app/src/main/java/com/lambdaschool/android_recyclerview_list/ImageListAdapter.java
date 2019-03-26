package com.lambdaschool.android_recyclerview_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageViewHolder> {

    private ArrayList<ImageData> imageDataArrayList;
    Context context;

    public ImageListAdapter(ArrayList<ImageData> imageDataArrayList) {
        this.imageDataArrayList = imageDataArrayList;
    }

    @NonNull
    @Override
    public ImageListAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater.from(context).inflate(R.id.image_view_item_image, viewGroup, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ImageViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewUri;
        ImageView imageViewImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.text_view_item_name);
            textViewUri=itemView.findViewById(R.id.text_view_item_uri);
            imageViewImage=itemView.findViewById(R.id.image_view_item_image);
        }
    }
}
