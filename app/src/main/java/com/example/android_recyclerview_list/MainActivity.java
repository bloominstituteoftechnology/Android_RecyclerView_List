package com.example.android_recyclerview_list;




import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    public static final int IMAGE_REQUEST_CODE = 1;
    Intent fullIntent;
    static Context mainContext;
    ImageListAdapter listAdapter;


    ArrayList picArray = new ArrayList<String>();
    StoredImage storedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        mainContext = this;
        listAdapter = new ImageListAdapter(picArray);
        setContentView ( R.layout.activity_main );

        Button      addButton   = findViewById ( R.id.button_add_to_list );


        addButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType ( "image/*" );
                startActivityForResult ( intent, IMAGE_REQUEST_CODE );
            }
        } );


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(resultCode == RESULT_OK && requestCode == IMAGE_REQUEST_CODE){
            if(data != null){
                ImageView picView = findViewById ( R.id.pic_image_view );
                Uri dataUri = data.getData();
                //TODO
                String dataString = dataUri.toString ();
                picArray.add(dataString);
                int listIndex = picArray.indexOf(dataString);

                listAdapter = new ImageListAdapter(picArray);
                RecyclerView recyclerView = findViewById(R.id.image_recycler_view);
                recyclerView.setAdapter(listAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager((this));
                recyclerView.setLayoutManager(layoutManager);

            }
        }
    }


//    public   TextView createTextView(final String imageText, final int listIndex){
//        fullIntent = new Intent(MainActivity.this, ImageDetails.class);
//        TextView        textView        = new TextView (getApplicationContext ());
//        LinearLayout    layoutLinear    = findViewById ( R.id.layout_linear_scroll );
//        layoutLinear.addView ( textView);
//        textView.setId ( listIndex );
//        textView.setText ( imageText );
//        textView.setTextSize(15);
//        textView.setPadding ( 10,10,10,10 );
//        textView.setWidth ( 200);
//        textView.setHeight ( 100 );
//        return textView;
//    }
}

