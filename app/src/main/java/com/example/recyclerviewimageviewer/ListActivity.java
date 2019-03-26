package com.example.recyclerviewimageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import static android.content.Intent.ACTION_GET_CONTENT;

public class ListActivity extends AppCompatActivity implements Serializable {

    private static int INDEX = 0;
    private static int REQUEST_CODE = 1337;
    //Index acts as the counter for the

    Button addButton;
    LinearLayout layoutScroll;
    ArrayList<ImageData> images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ActivityLifeCycle", this.getClass().getSimpleName() + " - OnCreate");

        images = new ArrayList<>();

        layoutScroll = findViewById(R.id.scrollLayout);

        addButton = findViewById(R.id.button_get_image);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                Uri dataUri = data.getData();
                images.add(INDEX, new ImageData(dataUri));
                layoutScroll.addView(createTextView(Uri.parse(images.get(INDEX).getUri()).getLastPathSegment(), INDEX));
            }
        }
    }

    private TextView createTextView(String text, int index) {
        final TextView textView = new TextView(getApplicationContext());
        final String textName = text;
        textView.setPadding(15, 3, 3, 15);
        textView.setText(text);
        textView.setId(index);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageDetailsActivity.class);
                intent.putExtra("key", images.get(textView.getId()).TAG);
                //intent.putExtra("keyName", textName);
                startActivity(intent);
            }
        });

        INDEX++;
        return textView;
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
