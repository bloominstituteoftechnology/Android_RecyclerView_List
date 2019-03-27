package com.lambdaschool.android_recyclerview_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageViewHolder> {

    private ArrayList<ImageData> imageDataArrayList;
    //Context context;

    public ImageListAdapter(ArrayList<ImageData> imageDataArrayList) {
        this.imageDataArrayList = imageDataArrayList;
    }

    public ArrayList<ImageData> getImageDataArrayList() {
        return imageDataArrayList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ImageViewHolder viewHolder, int position) {
        final ImageData imageData=imageDataArrayList.get(position);

        viewHolder.textViewUri.setText(imageData.getUri().toString());
        viewHolder.textViewName.setText(imageData.getName());

        viewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ImageDetailsActivity.class);
                intent.putExtra("Image", imageData);
                ((Activity)v.getContext()).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewUri;
        ImageView imageViewImage;
        View parentView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.text_view_item_name);
            textViewUri=itemView.findViewById(R.id.text_view_item_uri);
            imageViewImage=itemView.findViewById(R.id.image_view_item_image);

            parentView=itemView.findViewById(R.id.list_parent);
        }
    }
}
