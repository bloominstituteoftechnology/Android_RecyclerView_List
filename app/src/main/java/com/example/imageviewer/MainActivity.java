package com.example.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Intent.ACTION_GET_CONTENT;

public class MainActivity extends AppCompatActivity {

    private static int INDEX = 0;

    Button addButton;
    LinearLayout layoutScroll;
    ArrayList<ImageData> images;
    static int TO_DETAILS_REQUEST = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<>();

        layoutScroll = findViewById(R.id.scrollLayout);

        addButton = findViewById(R.id.button_get_image);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, INDEX);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (resultCode == RESULT_OK && requestCode == INDEX) {
            if (data != null) {
                Uri dataUri = data.getData();

                images.add(INDEX, new ImageData(dataUri));
                layoutScroll.addView(createTextView(Uri.parse(images.get(INDEX).getUri()).getLastPathSegment(), INDEX));
            }
        }
    }

}
