package com.rybarstudios.imageviewer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {
    @NonNull
    @Override
    public ImageListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListViewHolder imageListViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ImageListViewHolder extends RecyclerView.ViewHolder {

        public ImageListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
