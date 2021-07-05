package com.vivekvishwanath.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    private Button addImageButton;
    private LinearLayout imageListLayout;
    private ScrollView imageScrollView;
    private ArrayList<ImageData> imageDataMembers = new ArrayList<ImageData>();
    private int dataMemberIndex = 0;
    private Context context;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ImageListAdapter imageListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onCreate");
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        imageListAdapter = new ImageListAdapter(imageDataMembers);
        recyclerView.setAdapter(imageListAdapter);


        addImageButton = findViewById(R.id.add_image_button);
        addImageButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                                  intent.setType("image/*");
                                                  startActivityForResult(intent, REQUEST_CODE);
                                              }
                                          } );


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                Uri imageUri = data.getData();
                ImageData imageData = new ImageData();
                imageData.setUri(imageUri);
                imageData.setImageName(dataMemberIndex);
                dataMemberIndex++;
                imageDataMembers.add(imageData);

                imageListAdapter.notifyItemInserted(imageDataMembers.size()-1);
            }
        }
    }
}
