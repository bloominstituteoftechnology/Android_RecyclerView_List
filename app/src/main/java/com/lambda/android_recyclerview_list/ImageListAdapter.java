package com.lambda.android_recyclerview_list;

import android.content.Intent;
import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import  android.support.v7.widget.CardView;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder>{





    public static final int EDIT_ENTRY_REQUEST_CODE = 2;

    private ArrayList<ImageData> alImageData;
    Context context;


    public ImageListAdapter(ArrayList<ImageData> alImageData) {

        this.alImageData = alImageData;


    }



    @NonNull

    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();


        View entryView = LayoutInflater.from(context).inflate(R.layout.image_list_view, viewGroup, false);


        return new ViewHolder(entryView);

    }



    @Override

    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final ImageData id = this.alImageData.get(i);



        viewHolder.tvURL.setText(id.getStringUri());
        viewHolder.ivImage.setImageURI( id.getUri() );



        viewHolder.parent.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent detailIntent = new Intent(v.getContext(),   ImageListView.class);

                detailIntent.putExtra("ImageData", id                );

                ((Activity) v.getContext())

                        .startActivityForResult(detailIntent, EDIT_ENTRY_REQUEST_CODE);

            }

        });

    }



    @Override

    public int getItemCount() {

        return this.alImageData.size();

    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private CardView parent;

        private TextView tvURL;
        private ImageView ivImage;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            this.parent = itemView.findViewById(R.id.element_parent);

            this.tvURL = itemView.findViewById(R.id.text_url);

            this.ivImage= itemView.findViewById(R.id.image_view);


        }

    }

}