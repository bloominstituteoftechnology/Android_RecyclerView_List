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
    //Context context;

    public ImageListAdapter(ArrayList<ImageData> imageDataArrayList) {
        this.imageDataArrayList = imageDataArrayList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.id.constraint_layout_item, viewGroup, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ImageViewHolder viewHolder, int position) {
        ImageData imageData=imageDataArrayList.get(position);

        ImageViewHolder.textViewUri.setText(imageData.getUri().toString());
        ImageViewHolder.textViewName.setText(imageData.getName());
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
