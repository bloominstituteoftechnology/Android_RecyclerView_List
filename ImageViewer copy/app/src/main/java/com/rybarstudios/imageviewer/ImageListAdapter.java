package com.rybarstudios.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {

   private ArrayList<ImageData> entryData;

    public ImageListAdapter(ArrayList<ImageData> entryData) {
        this.entryData = entryData;
    }

    @NonNull
    @Override
    public ImageListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_entry_list_item,
                                                                            parent, false);
        return new ImageListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListViewHolder imageListViewHolder, int i) {
        final ImageData data = entryData.get(i);

        imageListViewHolder.mImageView.setImageURI(data.getUri());
        imageListViewHolder.imageNameView.setText(data.getName());

        imageListViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageDetails = new Intent(v.getContext(), DetailsActivity.class);
                imageDetails.putExtra(Intent.EXTRA_STREAM, data);
                ((Activity)v.getContext()).startActivity(imageDetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.entryData.size();
    }

    class ImageListViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView imageNameView;
        View parentView;

        public ImageListViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_image_view);
            imageNameView = itemView.findViewById(R.id.item_image_name);
            parentView = itemView.findViewById(R.id.list_parent);
        }
    }
}
