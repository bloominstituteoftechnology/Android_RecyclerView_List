package com.example.recyclerviewimageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ImageDetailsActivity extends AppCompatActivity implements Serializable {

    ImageView iv;
    TextView textViewURI;
    TextView textViewName;
    TextView textViewDescription;
    String uri;
    String name;
    ImageData imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - OnCreate");

        iv = findViewById(R.id.imageDetailsView);
        textViewURI = findViewById(R.id.textViewURI);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            imageData = (ImageData) intent.getSerializableExtra("key");
            setImage();
        }


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FullScreenImageActivity.class);
                intent.putExtra("key", uri);
                startActivity(intent);
            }
        });
    }

    public void setImage() {
        this.uri = imageData.getUri();
        iv.setImageURI(Uri.parse(uri));
        textViewURI.setText(uri);
    }

    public void setName(String name) {
        this.name = name;
        textViewName.setText(name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - OnDestory");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - OnResume");
    }
}
