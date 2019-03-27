package com.example.recyclerlist;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST_CODE = 50;
    // create ImageData variable
    ImageData imageData;
    // int that will track how many images the user has added
    private int imageIndex = 0;
    private LinearLayout linearLayoutChild;
    // Arraylist that will hold all the imageData TextView Objects
    ArrayList<ImageData> imageList = new ArrayList<>();


    RecyclerView recyclerView;
    ImageListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ActivityStateTracking", String.format("%s - onCreate", getLocalClassName()));





        // Listener for pushing the add-image button, implicit intent to get image
        findViewById(R.id.button_add_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGE_REQUEST_CODE);
            }

        });
                recyclerView = findViewById(R.id.actual_recycle_view);
                listAdapter = new ImageListAdapter(imageList);
                recyclerView.setAdapter(listAdapter);
                LinearLayoutManager llm = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(llm);
    }
    //TextView generator
   /* public TextView createView(String text,final int number){

        TextView tv = new TextView(this);
        text = "#" + number + ": " + text;
        tv.setText(text);
        tv.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setTextSize(20);


        //TextView generator's onclick listener


        return tv;
    }*/



    // What the app does when it gets an image back
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == IMAGE_REQUEST_CODE) {
            if (data != null) {
                Uri dataUri = data.getData();
                imageData = new ImageData("name",dataUri.toString());
                imageList.add (imageIndex++,imageData);    //Update arraylist of imageDatas

               // listAdapter.notifyDataSetChanged();
                listAdapter.notifyItemChanged(imageList.size());
            }
        }
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
