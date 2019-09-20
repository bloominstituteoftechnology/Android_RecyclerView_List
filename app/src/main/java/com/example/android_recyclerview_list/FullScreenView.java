package com.example.android_recyclerview_list;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.Serializable;

public class FullScreenView extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);

        Intent full = getIntent();
        Uri fullPicUri = (Uri) full.getSerializableExtra("pic");
        ImageView picture = findViewById(R.id.fullscreen_pic);
        picture.setImageURI(fullPicUri);
    }


}
