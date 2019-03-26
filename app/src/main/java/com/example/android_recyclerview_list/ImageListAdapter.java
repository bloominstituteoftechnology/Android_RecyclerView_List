package com.example.android_recyclerview_list;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public  class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

ArrayList<StoredImage> entryData;


    public ImageListAdapter(ArrayList<StoredImage> entryData) {
        this.entryData = entryData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageListAdapter.ViewHolder holder, int position) {
        StoredImage data = entryData.get(position);
        final int listIndex = position;
        final String dataString = data.toString();
        holder.itemImageView.setImageURI(Uri.parse(dataString));
        holder.itemTextView.setText(dataString);
        //        textView.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                fullIntent.putExtra("index", listIndex);
        //                fullIntent.putExtra("name", imageText );
        //                startActivity(fullIntent);
        holder.itemTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullIntent = new Intent(MainActivity.mainContext, ImageDetails.class);
                fullIntent.putExtra("index", listIndex);
                fullIntent.putExtra("name", dataString);
                MainActivity.mainContext.startActivity(fullIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.entryData.size();
    }

class ViewHolder extends RecyclerView.ViewHolder{
    ConstraintLayout parentView;
    ImageView itemImageView;
    TextView itemTextView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.item_layout_item_name);
        itemImageView = itemView.findViewById(R.id.item_layout_item_image);

        parentView = itemView.findViewById(R.id.item_layout_parent_layout);

    }
}

}
