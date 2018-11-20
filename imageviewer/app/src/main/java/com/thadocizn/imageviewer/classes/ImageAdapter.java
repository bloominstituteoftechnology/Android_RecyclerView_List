package com.thadocizn.imageviewer.classes;

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

import com.thadocizn.imageviewer.R;
import com.thadocizn.imageviewer.activities.DetailsActivity;
import com.thadocizn.imageviewer.activities.MainActivity;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private Context context;

    ArrayList<ImageData> imageList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtTitle;
        public ImageView imgPicture;
        public LinearLayout parentLayout;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = view.findViewById(R.id.tvTitle);
            imgPicture = view.findViewById(R.id.ivPicture);
            parentLayout = view.findViewById(R.id.parentLayout);
        }
    }

    public ImageAdapter(ArrayList<ImageData> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);

        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final ImageData imageData = imageList.get(i);
        final String  test = imageData.getName();
        myViewHolder.txtTitle.setText(test);
        myViewHolder.imgPicture.setImageURI(imageData.getUri());
        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(MainActivity.IMAGE_URL, imageData.getUri().toString());
                intent.putExtra(MainActivity.IMAGE_NAME, test);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

}
