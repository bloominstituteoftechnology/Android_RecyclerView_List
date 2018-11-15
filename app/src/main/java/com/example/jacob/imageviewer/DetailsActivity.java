package com.example.jacob.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity {
    ImageView imagePreview;
    private Context context;
    ImageData detailsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        context = this;
        imagePreview = findViewById(R.id.image_preview);
        Intent intent = getIntent();

        detailsImage = (ImageData) intent.getSerializableExtra("DISPLAY_IMAGE");
        Uri imageUri = detailsImage.getImageUri();
        imagePreview.setImageURI(imageUri);

        imagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clickIntent = new Intent(context, FullscreenActivity.class);
                clickIntent.putExtra("FULLSCREEN_IMAGE", detailsImage);
                startActivity(clickIntent);
            }
        });
        ((TextView) findViewById(R.id.image_details_name)).setText(detailsImage.getImageName());
        ((TextView) findViewById(R.id.image_details_uri)).setText(imageUri.toString());
    }
}
