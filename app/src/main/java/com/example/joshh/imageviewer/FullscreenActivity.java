package com.example.joshh.imageviewer;

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
public class FullscreenActivity extends AppCompatActivity {

    private ImageView fullscreenImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        Log.i("FullscreenActivtyState", String.format("%s - onCreate", getLocalClassName()));

        fullscreenImageView = findViewById(R.id.image_view_fullscreen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("FullscreenActivtyState", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String imageUri = intent.getStringExtra("uri");
        fullscreenImageView.setImageURI(Uri.parse(imageUri));

        Log.i("FullscreenActivtyState", String.format("%s - onResume", getLocalClassName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("FullscreenActivtyState", String.format("%s - onPause", getLocalClassName()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("FullscreenActivtyState", String.format("%s - onStop", getLocalClassName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("FullscreenActivtyState", String.format("%s - onDestroy", getLocalClassName()));
    }
}
