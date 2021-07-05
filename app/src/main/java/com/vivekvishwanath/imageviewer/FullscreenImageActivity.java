package com.vivekvishwanath.imageviewer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenImageActivity extends AppCompatActivity {


    private ImageView fullscreenImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onCreate");

        setContentView(R.layout.activity_fullscreen_image);

        fullscreenImageView = findViewById(R.id.fullscreen_image_view);
        Intent intent = getIntent();
        String imageUri = (String) intent.getSerializableExtra("fullscreen");
        fullscreenImageView.setImageURI(Uri.parse(imageUri));
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


}



