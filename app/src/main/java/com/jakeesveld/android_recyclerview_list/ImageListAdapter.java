package com.jakeesveld.android_recyclerview_list;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageEntryViewHolder>{

    public ImageListAdapter(ArrayList<ImageData> dataList) {
        this.dataList = dataList;
    }

    private ArrayList<ImageData> dataList;

    @NonNull
    @Override
    public ImageEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_layout, parent, false);
        return new ImageEntryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageEntryViewHolder viewHolder, int i) {
        final ImageData data = dataList.get(i);

        viewHolder.imageNameView.setText(data.getName());
        viewHolder.imagePreviewView.setImageURI(data.getImageUri());

        viewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewerActivity.class);
                intent.putExtra("image", data);
                ((Activity)v.getContext()).startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ImageEntryViewHolder extends RecyclerView.ViewHolder{

        View parentView;
        TextView imageNameView;
        ImageView imagePreviewView;

        public ImageEntryViewHolder(@NonNull View itemView) {
            super(itemView);
            parentView = itemView.findViewById(R.id.layout_parent);
            imageNameView = itemView.findViewById(R.id.item_text_name);
            imagePreviewView = itemView.findViewById(R.id.item_image_preview);
        }
    }
}
