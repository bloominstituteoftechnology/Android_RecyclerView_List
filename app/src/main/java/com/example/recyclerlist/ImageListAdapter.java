package com.example.recyclerlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    ArrayList<ImageData> imageList = new ArrayList<>();
    Context context;

    public ImageListAdapter(ArrayList<ImageData> entryData) {
        this.imageList = entryData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_file_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // S02M02-4 our connection to the views in the layout
        class ViewHolder extends RecyclerView.ViewHolder {

            TextView nameTextView, uriTextView;
            ImageView imageView;
            View parentView;

            // bind the data members of our viewholder to the items in the layout
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nameTextView = itemView.findViewById(R.id.recycler_textView_name);
                uriTextView = itemView.findViewById(R.id.recycler_textview_uri);
                imageView = itemView.findViewById(R.id.recycler_image_view);

                parentView = itemView.findViewById(R.id.recycler_parent_view);
            }
        }


}