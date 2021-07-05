package com.vivekvishwanath.imageviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private ImageView selectedImageView;
    private TextView imageNameView;
    private TextView imageUriView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onCreate");
        setContentView(R.layout.activity_details);

        selectedImageView = findViewById(R.id.selected_image);
        imageNameView = findViewById(R.id.image_name);
        imageUriView = findViewById(R.id.image_uri);

        Intent imageIntent = getIntent();
        final ImageData IMAGE_DATA = (ImageData) imageIntent.getSerializableExtra("image");

        imageNameView.setText("Name - " + IMAGE_DATA.getImageName());
        imageNameView.setTextSize(20);
        imageNameView.setPadding(10,10,10,10);
        imageNameView.setTextColor(getResources().getColor(android.R.color.black));

        imageUriView.setText("Image URI - " + IMAGE_DATA.getUri().toString());
        imageUriView.setTextSize(20);
        imageUriView.setPadding(10,10,10,10);
        imageUriView.setTextColor(getResources().getColor(android.R.color.black));

        selectedImageView.setImageURI(IMAGE_DATA.getUri());
        selectedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullscreenIntent = new Intent(getApplicationContext(), FullscreenImageActivity.class);
                fullscreenIntent.putExtra("fullscreen", IMAGE_DATA.getUri().toString());
                startActivity(fullscreenIntent);
            }
        });

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

        Intent imageIntent = getIntent();
        final ImageData IMAGE_DATA = (ImageData) imageIntent.getSerializableExtra("image");

        imageNameView.setText("Name - " + IMAGE_DATA.getImageName());
        imageNameView.setTextSize(20);
        imageNameView.setPadding(10,10,10,10);
        imageNameView.setTextColor(getResources().getColor(android.R.color.black));

        imageUriView.setText("Image URI - " + IMAGE_DATA.getUri().toString());
        imageUriView.setTextSize(20);
        imageUriView.setPadding(10,10,10,10);
        imageUriView.setTextColor(getResources().getColor(android.R.color.black));

        selectedImageView.setImageURI(IMAGE_DATA.getUri());
        selectedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullscreenIntent = new Intent(getApplicationContext(), FullscreenImageActivity.class);
                fullscreenIntent.putExtra("fullscreen", IMAGE_DATA.getUri().toString());
                startActivity(fullscreenIntent);
            }
        });
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
}
