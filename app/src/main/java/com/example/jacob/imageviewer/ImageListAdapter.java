package com.example.jacob.imageviewer;

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


public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.layout_item_details);
            imageView = itemView.findViewById(R.id.image_item_preview);
            textView = itemView.findViewById(R.id.text_item_title);
        }
    }

    private ArrayList<ImageData> dataList;
    private Context context;

    public ImageListAdapter(ArrayList<ImageData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageListAdapter.ViewHolder holder, int position){
        final ImageData data = dataList.get(position);
        holder.textView.setText(data.getImageName());
        holder.imageView.setImageURI(data.getImageUri());
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent clickIntent = new Intent(context, DetailsActivity.class);
                clickIntent.putExtra("DISPLAY_IMAGE",data);
                context.startActivity(clickIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
       return dataList.size();
    }
}
