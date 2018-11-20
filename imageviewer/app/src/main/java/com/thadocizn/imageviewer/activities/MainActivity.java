package com.thadocizn.imageviewer.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thadocizn.imageviewer.R;
import com.thadocizn.imageviewer.classes.ImageAdapter;
import com.thadocizn.imageviewer.classes.ImageData;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int IMAGE_REQUEST_CODE = 72;
    public static final String IMAGE_URL = "imageUrl";
    public static final String IMAGE_NAME = "image_name";
    public static final String IMAGE_ID = "imageId";
    private ArrayList<ImageData> imageArray;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, String.format("%s - onCreate", getLocalClassName()));

        setContentView(R.layout.activity_main);

        imageArray = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleViewer);
        adapter = new ImageAdapter(imageArray);


        findViewById(R.id.btnAddImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent imageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent, IMAGE_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == IMAGE_REQUEST_CODE) {
                if (data != null){
                    Uri imageUri = data.getData();
                    ImageData newImageData = null;
                    if (imageUri != null) {
                        newImageData = new ImageData(imageUri.toString(), imageArray.size());
                    }

                    imageArray.add(newImageData);
                    int imageIndex = imageArray.size() - 1;
                    adapter.notifyItemInserted(imageIndex);


                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    DividerItemDecoration itemDecor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
                    recyclerView.addItemDecoration(itemDecor);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);

                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, String.format("%s - onStop", getLocalClassName()));

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, String.format("%s - onPause", getLocalClassName()));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, String.format("%s - onStart", getLocalClassName()));

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, String.format("%s - onResume", getLocalClassName()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, String.format("%s - onDestroy", getLocalClassName()));

    }
}
