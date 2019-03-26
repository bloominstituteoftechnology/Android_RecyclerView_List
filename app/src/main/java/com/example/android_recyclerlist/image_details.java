package com.example.android_recyclerlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class image_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        Log.i("ActivityStateTracking", String.format("%s - onCreate", getLocalClassName()));

        Intent intent = getIntent();
        final ImageData myObject;
        myObject = (ImageData)intent.getSerializableExtra("Image_Key");


        ImageView imageView = findViewById(R.id.layout_image);
        imageView.setImageURI(myObject.getUri());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData temp;
                temp = myObject;
                Intent intent = new Intent(getApplicationContext(),FullscreenActivity.class);
                intent.putExtra("Image_Key", temp);
                startActivity(intent);
                //test change


            }
        });


        EditText et = findViewById(R.id.layout_edit_text);
        et.setText(myObject.getName());
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("ActivityStateTracking", String.format("%s - onPostResume", getLocalClassName()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityStateTracking", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityStateTracking", String.format("%s - onStop", getLocalClassName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityStateTracking", String.format("%s - onDestroy", getLocalClassName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityStateTracking", String.format("%s - onPause", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityStateTracking", String.format("%s - onResume", getLocalClassName()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityStateTracking", String.format("%s - onRestart", getLocalClassName()));
    }
}
