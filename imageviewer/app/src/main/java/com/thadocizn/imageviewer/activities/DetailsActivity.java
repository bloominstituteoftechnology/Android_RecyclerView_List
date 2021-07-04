package com.thadocizn.imageviewer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thadocizn.imageviewer.R;
import com.thadocizn.imageviewer.classes.ImageData;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    public static final String IMAGE_URL = "imageUrl";
    private static final String TAG = DetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Log.i(TAG, String.format("%s - onCreate", getLocalClassName()));


        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        final String image = intent.getStringExtra(MainActivity.IMAGE_URL);
        int index = Objects.requireNonNull(getIntent().getExtras()).getInt(MainActivity.IMAGE_ID);
        final String imageName = intent.getStringExtra(MainActivity.IMAGE_NAME);

        ImageData imageData = new ImageData(imageName, image, index);

        intent.getSerializableExtra(image);
        textView.setText(imageData.getName());
        imageView.setImageURI(imageData.getUri());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), FullscreenActivity.class);
                intent1.putExtra(IMAGE_URL, image);
                startActivity(intent1);

            }
        });

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
