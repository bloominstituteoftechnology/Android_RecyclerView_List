package com.example.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Intent.ACTION_GET_CONTENT;

public class MainActivity extends AppCompatActivity {

    private static int INDEX = 0;

    Button addButton;
    ImageListAdapter listAdapter;
    ArrayList<ImageData> images;
    RecyclerView recyclerView;
    static int TO_DETAILS_REQUEST = 42;
    static int NEW_IMAGE_REQUEST = 33;

    @Override
    protected void onResume() {
        super.onResume();
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.image_recycler_view);
        recyclerView.setHasFixedSize(true);
        images = new ArrayList<>();
        listAdapter = new ImageListAdapter(images);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(layoutManager);


/*        images.add(new ImageData(Uri.parse("testing"), 0));
        images.add(new ImageData(Uri.parse("testing"), 1));*/

        addButton = findViewById(R.id.add_image_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, NEW_IMAGE_REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (resultCode == RESULT_OK && requestCode == NEW_IMAGE_REQUEST) {
            if (data != null) {
                Uri dataUri = data.getData();
                ImageData image = new ImageData(dataUri, images.size());

                images.add(image);
                listAdapter.notifyItemChanged(images.size()-1);
            }
        }
    }

}
