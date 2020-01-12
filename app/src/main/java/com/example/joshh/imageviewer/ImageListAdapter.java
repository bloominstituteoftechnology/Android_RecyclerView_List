package com.example.joshh.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView titleText;
        private LinearLayout parentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            titleText = itemView.findViewById(R.id.image_name);
            parentView = itemView.findViewById(R.id.parent_view);
        }
    }

    private ArrayList<ImageData> imageData;
    private Context context;
    private Activity activity;

    public ImageListAdapter(ArrayList<ImageData> imageData, Activity activity) {
        this.imageData = imageData;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.image_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ImageData image = imageData.get(position);
        holder.titleText.setText(image.getName());
        holder.image.setImageURI(image.getUri());
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailActivityIntent = new Intent(context, ImageDetailsActivity.class);
                detailActivityIntent.putExtra("image", image);
                activity.startActivity(detailActivityIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageData.size();
    }
}
