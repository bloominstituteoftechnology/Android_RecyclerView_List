package com.example.jacob.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST_CODE = 3;
    private Context context;
    private ArrayList<ImageData> imageArrayList = new ArrayList<>();
    LinearLayout LayoutImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        findViewById(R.id.button_pickimage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent, IMAGE_REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_REQUEST_CODE) {
                Uri imageUri = data.getData();
//                Log.i("Test", imageUri.getPath());
                String imageName = imageUri.getPath().split("document/")[1];
//                Log.i("Test", imageName);
                ImageData selectedImage = new ImageData(imageUri, imageName);
                imageArrayList.add(selectedImage);
                LayoutImageList = findViewById(R.id.layout_imagelist);
                LayoutImageList.addView(TextViewGenerator(imageName, imageArrayList.size()-1));
            }
        }

    }

    private TextView TextViewGenerator(String displayText, final int listIndex) {
        /*
        *            <TextView
                android:text="placeholder"
                android:textSize="32sp"
                android:padding="15dp"
                android:textAlignment="center"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
         */

        TextView view = new TextView(context);
        view.setText(displayText);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        view.setPadding(15, 15, 15, 15);
        view.setTextAlignment(view.TEXT_ALIGNMENT_CENTER);
        view.setWidth(2000);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData photoData;
                photoData = imageArrayList.get(listIndex);
                Intent clickIntent = new Intent(context, DetailsActivity.class);
                clickIntent.putExtra("DISPLAY_IMAGE",photoData);
                startActivity(clickIntent);
            }
        });
        return view;
    }
}
