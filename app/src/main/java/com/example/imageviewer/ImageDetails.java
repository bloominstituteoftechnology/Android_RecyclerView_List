package com.example.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDetails extends AppCompatActivity {

    ImageView iv;
    TextView textViewURI;
    TextView textViewName;
    TextView textViewDescription;
    String uri;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        iv =  findViewById(R.id.imageDetailsView);
        textViewURI = findViewById(R.id.textViewURI);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            setName(bundle.getString("key"));
            setImage(bundle.getString("key"));
        }



        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FullScreenImage.class);
                intent.putExtra("key", uri);
                startActivity(intent);
            }
        });
    }

    public void setImage(String uri){
        this.uri = uri;
        iv.setImageURI(Uri.parse(uri));
        textViewURI.setText(uri);
    }

    public void setName(String uri){
        this.name = Uri.parse(uri).getLastPathSegment();
        textViewName.setText(name);
    }
}
