package com.lambda.android_recyclerview_list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ImageListView extends AppCompatActivity {
    private ArrayList<ImageData> alImageData=new ArrayList<ImageData>(100  );
    private RecyclerView entryRecyclerView;
    private ImageListAdapter ilaAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_image_list_view );
        ReceiveData();
        context = getApplicationContext();

        ilaAdapter=new ImageListAdapter( alImageData );

        entryRecyclerView = findViewById(R.id.recycler_view);
        entryRecyclerView.setAdapter( ilaAdapter );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        entryRecyclerView.setLayoutManager(linearLayoutManager);

    }






    public void ReceiveData(){
        alImageData=(ArrayList<ImageData>)getIntent().getSerializableExtra("DATA_I_NEED");
        ImageListAdapter ila=new ImageListAdapter( alImageData );

    }


}
