package com.example.android_recyclerview_list;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ImageDetails extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        TextView fullScreen = findViewById(R.id.fullscreen_content);
        ImageView fullPic = findViewById(R.id.fullscreen_picture);
        Intent intent = getIntent();
        final StoredImage image = (StoredImage) intent.getSerializableExtra("name");
        fullPic.setImageURI(image.getUriPic());
        fullScreen.setText(image.getUriString());

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullScreen = new Intent(ImageDetails.this, FullScreenView.class);
                fullScreen.putExtra("pic", image);
                startActivity(fullScreen);
            }
        });
    }
}
