package com.lambdaschool.android_recyclerview_list;

import android.content.Context;
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

//import com.lambdaschool.imageviewer.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private LinearLayout linearLayout;
    private ImageData imageData;
    private ArrayList<ImageData> arrayList = new ArrayList<ImageData>();
    ImageListAdapter imageListAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        Log.i("ActivityStateTracking", String.format("%s - onCreate", getLocalClassName()));

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_pick_image);

        linearLayout = findViewById(R.id.linear_layout_list_images);

//        imageListAdapter=new ImageListAdapter(ImageListAdapter.ImageViewHolder.)
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            if (data != null) {
                Uri dataUri = data.getData();
                ImageData imageData2 = new ImageData();
                imageData2.setName(((Uri)dataUri).toString());
                imageData2.setUri(dataUri);
                arrayList.add(imageData2);
                int elementIndex = arrayList.indexOf(imageData2);
                imageData2.setName("Image: " + elementIndex);
//                linearLayout.addView(generateTextView(imageData2.getName(), elementIndex));
            }
        }
    }

/*    private TextView generateTextView(String text, final int elementIndex) {
        TextView newTextView = new TextView(this);
        newTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        newTextView.setText(text);
        newTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageDetailsActivity.class);
                ImageData newImageData =  arrayList.get(elementIndex);
                intent.putExtra("Image", newImageData);
                startActivity(intent);
            }
        });

        return newTextView;
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityStateTracking", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityStateTracking", String.format("%s - onResume", getLocalClassName()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }

    // User interacting with app

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityStateTracking", String.format("%s - onPause", getLocalClassName()));
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

        System.gc();
    }
}
