package com.vivekvishwanath.imageviewer;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    
    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout imageDataParentLayout;
        TextView imageNameView, imageUriView;

        public ViewHolder(View itemView){
            super(itemView);

            imageDataParentLayout = itemView.findViewById(R.id.imageData_parent_layout);
            imageNameView = itemView.findViewById(R.id.image_name_view);
            imageUriView = itemView.findViewById(R.id.image_uri_view);
    }
    }
}
