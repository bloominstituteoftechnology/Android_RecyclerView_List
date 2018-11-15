package com.example.joshh.imageviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDetailsActivity extends AppCompatActivity {

    private TextView nameText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameText = ((TextView)findViewById(R.id.name));
        imageView = ((ImageView)findViewById(R.id.imageView));

        Log.i("DetailsActivtyState", String.format("%s - onCreate", getLocalClassName()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DetailsActivtyState", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        final ImageData imageData = (ImageData) intent.getSerializableExtra("image");
        nameText.setText(imageData.getName());
        imageView.setImageURI(imageData.getUri());
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent fullScreenIntent = new Intent(ImageDetailsActivity.this, FullscreenActivity.class);
                fullScreenIntent.putExtra("uri", imageData.getUri().toString());
                startActivity(fullScreenIntent);
            }
        });

        Log.i("DetailsActivtyState", String.format("%s - onResume", getLocalClassName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DetailsActivtyState", String.format("%s - onPause", getLocalClassName()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DetailsActivtyState", String.format("%s - onStop", getLocalClassName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DetailsActivtyState", String.format("%s - onDestroy", getLocalClassName()));
    }
}
