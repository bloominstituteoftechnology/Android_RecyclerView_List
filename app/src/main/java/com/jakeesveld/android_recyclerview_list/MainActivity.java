package com.jakeesveld.android_recyclerview_list;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int IMAGE_REQUEST_CODE = 1;
    Integer imageIndex = 0;
    ArrayList<ImageData> list = new ArrayList();

    LinearLayout layoutList;
    Button buttonSelectImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ActivityLifecycle", getLocalClassName() + " - onCreate");
        setContentView(R.layout.activity_main);
        layoutList = findViewById(R.id.layout_list);
        buttonSelectImage = findViewById(R.id.button_select_image);
        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGE_REQUEST_CODE);
            }
        });
    }

    public TextView createTextView(String name, int index){
        final TextView post = new TextView(getApplicationContext());
        post.setText(name);
        post.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        post.setTextSize(24);
        post.setId(index);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = post.getId();
                ImageData object = list.get(index);
                Intent intent = new Intent(getApplicationContext(), ViewerActivity.class);
                intent.putExtra("image", object);
                startActivity(intent);


            }
        });

        return post;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_REQUEST_CODE){
            if (data != null){
                String imageName = "Image#" + imageIndex.toString();
                ImageData post = new ImageData(imageName, data.getData());
                list.add(post);
                TextView textView = createTextView(imageName, imageIndex);
                layoutList.addView(textView);
                imageIndex++;

            }
        }
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

    // user interacting with app

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

