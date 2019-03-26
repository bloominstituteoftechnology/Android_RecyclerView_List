package com.vivekvishwanath.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    private Button addImageButton;
    private LinearLayout imageListLayout;
    private ScrollView imageScrollView;
    private ArrayList<ImageData> imageDataMembers = new ArrayList<ImageData>();
    private int dataMemberIndex = 0;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ActivityLifeCycle", getLocalClassName() + " - onCreate");
        setContentView(R.layout.activity_main);

        context = this;

        addImageButton = findViewById(R.id.add_image_button);
        addImageButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                                  intent.setType("image/*");
                                                  startActivityForResult(intent, REQUEST_CODE);
                                              }
                                          } );


        imageListLayout = findViewById(R.id.image_list_layout);
        imageScrollView = findViewById(R.id.image_scroll_view);


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

    public TextView createTextView(String imageText, final int index) {
        TextView textView = new TextView(this);
        textView.setPadding(10,10,10,10);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        textView.setTextSize(20);
        textView.setPadding(10,10,10,10);
        textView.setText(imageText);
        textView.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData imageData = imageDataMembers.get(index);
                Intent detailsIntent = new Intent(getApplicationContext(), DetailsActivity.class);
                detailsIntent.putExtra("image", imageData);
                startActivity(detailsIntent);
            }
        });
        return textView;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                Uri imageUri = data.getData();
                ImageData imageData = new ImageData();
                imageData.setUri(imageUri);
                imageData.setImageName(dataMemberIndex);
                imageDataMembers.add(imageData);
                imageListLayout.addView(createTextView(imageData.getImageName(), dataMemberIndex));
                dataMemberIndex++;
            }
        }
    }
}
