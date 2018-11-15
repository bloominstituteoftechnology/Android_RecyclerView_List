package com.example.joshh.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Activity activity;

    private static final int IMAGE_REQUEST_CODE = 0;
    private ArrayList<ImageData> imageArrayList = new ArrayList<ImageData>();
    private  LinearLayout ll;
    private Button selectImageButton;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ImageListAdapter imageListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        //ll = (LinearLayout) findViewById(R.id.scroll_view_ll);
        selectImageButton = findViewById(R.id.select_image_button);

        recyclerView = findViewById(R.id.image_list_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        imageListAdapter = new ImageListAdapter(imageArrayList, activity);
        recyclerView.setAdapter(imageListAdapter);
        Log.i("ListActivtyState", String.format("%s - onCreate", getLocalClassName()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ListActivtyState", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        selectImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent getImageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getImageIntent.setType("image/*");
                startActivityForResult(getImageIntent, IMAGE_REQUEST_CODE);
            }
        });

        Log.i("ListActivtyState", String.format("%s - onResume", getLocalClassName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ListActivtyState", String.format("%s - onPause", getLocalClassName()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ListActivtyState", String.format("%s - onStop", getLocalClassName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ListActivtyState", String.format("%s - onDestroy", getLocalClassName()));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            if (requestCode == IMAGE_REQUEST_CODE) {
                String photoUri = data.getData().toString();
                ImageData imageData = new ImageData("image", photoUri);
                imageListAdapter.notifyItemInserted(imageArrayList.size());
                imageArrayList.add(imageData);
                //TextView tv = createTextView(photoUri, imageArrayList.indexOf(imageData));
                //ll.addView(tv);
            }
        }
    }

    /*private TextView createTextView(String text, final int index){
        TextView tv = new TextView(getApplicationContext());
        LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        tv.setLayoutParams(lp);
        tv.setText(text + " " + index);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData image = imageArrayList.get(index);
                Intent detailActivityIntent = new Intent(context, ImageDetailsActivity.class);
                detailActivityIntent.putExtra("image", image);
                startActivity(detailActivityIntent);
            }
        });
        return tv;
    }*/
}
