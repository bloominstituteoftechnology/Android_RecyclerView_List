package com.example.android_recyclerview_list;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        final Context context = this;

        TextView fullScreen = findViewById(R.id.fullscreen_content);
        ImageView fullPic = findViewById(R.id.fullscreen_picture);
        Intent intent = getIntent();
        final String imageText = (String) intent.getSerializableExtra("name");
        Uri imageUri = Uri.parse(imageText);
        fullPic.setImageURI(imageUri);
        fullScreen.setText(imageText);

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullScreen = new Intent(ImageDetails.this, FullScreenView.class);
                fullScreen.putExtra("pic", imageText);
                startActivity(fullScreen);
            }
        });
    }
}
