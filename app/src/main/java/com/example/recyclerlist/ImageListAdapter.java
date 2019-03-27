package com.example.recyclerlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.JarOutputStream;


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
        final ImageData data = imageList.get(i);

        viewHolder.nameTextView.setText(data.getName());
        viewHolder.uriTextView.setText(data.getUri().toString());
        viewHolder.imageView.setImageURI(data.getUri());

        viewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData temp;
                //temp = imageList.get(number);
                Intent intent = new Intent(v.getContext(),image_details.class);
                //intent.putExtra("Image_Key", temp);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return this.imageList.size();
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