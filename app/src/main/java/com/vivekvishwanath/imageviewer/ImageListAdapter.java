package com.vivekvishwanath.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    ArrayList<ImageData> imageDataList;
    Context context;

    public ImageListAdapter(ArrayList<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }

    @NonNull
    @Override
    public ImageListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.image_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ViewHolder holder, int position) {
        final ImageData imageData = imageDataList.get(position);
        holder.imageNameView.setText(imageData.getImageName());
        holder.imageUriView.setText(imageData.getUri().toString());

        holder.imageDataParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("image", imageData);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout imageDataParentLayout;
        TextView imageNameView, imageUriView;

        public ViewHolder(View itemView){
            super(itemView);

            imageDataParentLayout = itemView.findViewById(R.id.image_list_view);
            imageNameView = itemView.findViewById(R.id.image_name_view);
            imageUriView = itemView.findViewById(R.id.image_uri_view);
    }
    }
}
