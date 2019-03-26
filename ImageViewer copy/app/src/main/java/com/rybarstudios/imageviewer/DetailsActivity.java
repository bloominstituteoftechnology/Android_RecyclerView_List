package com.rybarstudios.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity implements Serializable {

    private Context context;
    private ImageView imageView;
    private ImageData myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.i("ActivityLifecycle", getLocalClassName() + " - onCreate");

        context = this;

        imageView = findViewById(R.id.view_image);

        Intent imageIntent = getIntent();
//        final Uri imageUri = Uri.parse(imageIntent.getStringExtra(Intent.EXTRA_STREAM));
        myImage = (ImageData) imageIntent.getSerializableExtra(Intent.EXTRA_STREAM);
        imageView.setImageURI(myImage.getUri());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullscreenActivity.class);
                intent.putExtra(Intent.EXTRA_STREAM, myImage.getUri());
                startActivity(intent);
            }
        });

        ((TextView)findViewById(R.id.view_image_name)).setText(imageIntent.getStringExtra(Intent.EXTRA_TEXT));

        ((TextView)findViewById(R.id.view_image_uri)).setText(imageIntent.getStringExtra(Intent.EXTRA_STREAM));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifecycle", getLocalClassName() + " - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityLifecycle", getLocalClassName() + " - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityLifecycle", getLocalClassName() + " - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityLifecycle", getLocalClassName() + " - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityLifecycle", getLocalClassName() + " - onDestroy");
    }

}
