package com.lambdaschool.android_recyclerview_list;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.lambdaschool.imageviewer.R;

public class ImageDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewName;
    TextView textViewUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("ActivityStateTracking", String.format("%s - onCreate", getLocalClassName()));

        setContentView(R.layout.image_details);

        imageView = findViewById(R.id.image_view_details_image);
        textViewName = findViewById(R.id.text_view_details_name);
        textViewUri = findViewById(R.id.text_view_details_uri);

        Intent intent = getIntent();
        final ImageData newImageData = (ImageData)intent.getSerializableExtra("Image");

        textViewName.setText(newImageData.getName());
        textViewUri.setText(newImageData.getUri().toString());
        imageView.setImageURI(newImageData.getUri());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FullscreenActivity.class);
                intent.putExtra("Image", newImageData.getUri().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityStateTracking", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityStateTracking", String.format("%s - onResume", getLocalClassName()));
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
/*
    private TextView createEntryView( entry) {

        TextView view = new TextView(context);
        view.setText(entry.getDate() + " - " + entry.getDayRating());
        view.setPadding(15, 15, 15, 15);
        view.setTextSize(22);
        //view.setTypeface(Typeface.BOLD);
    }

    private void addTestEntry() {
        String one = "Star stuff harvesting star light white dwarf made in the interiors of collapsing stars two ghostly white figures in coveralls and helmets are soflty dancing at the edge of forever rich in heavy atoms. Take root and flourish paroxysm of global death across the centuries not a sunrise but a galaxyrise quasar the only home we've ever known? The only home we've ever known realm of the galaxies hearts of the stars citizens of distant epochs invent the universe extraordinary claims require extraordinary evidence?";
        String two = "Realm of the galaxies citizens of distant epochs not a sunrise but a galaxyrise dream of the mind's eye Sea of Tranquility finite but unbounded. The ash of stellar alchemy from which we spring gathered by gravity vastness is bearable only through love muse about with pretty stories for which there's little good evidence. The carbon in our apple pies extraordinary claims require extraordinary evidence courage of our questions take root and flourish a very small stage in a vast cosmic arena stirred by starlight.";
        String three = "Culture extraplanetary extraordinary claims require extraordinary evidence vanquish the impossible a still more glorious dawn awaits stirred by starlight. Great turbulent clouds encyclopaedia galactica tesseract dispassionate extraterrestrial observer Sea of Tranquility from which we spring? The only home we've ever known a very small stage in a vast cosmic arena something incredible is waiting to be known something incredible is waiting to be known the only home we've ever known dream of the mind's eye.";
        String four = "Gathered by gravity Apollonius of Perga Euclid cosmic fugue stirred by starlight light years. Cosmic ocean white dwarf intelligent beings finite but unbounded circumnavigated cosmic ocean. Cosmic ocean hydrogen atoms two ghostly white figures in coveralls and helmets are soflty dancing venture vastness is bearable only through love are creatures of the cosmos? Concept of the number one two ghostly white figures in coveralls and helmets are soflty dancing cosmic ocean two ghostly white figures in coveralls and helmets are soflty dancing vanquish the impossible a very small stage in a vast cosmic arena.";
        String five = "Finite but unbounded Flatland from which we spring ship of the imagination rich in heavy atoms light years? Encyclopaedia galactica the sky calls to us the carbon in our apple pies the sky calls to us preserve and cherish that pale blue dot billions upon billions? Dispassionate extraterrestrial observer bits of moving fluff inconspicuous motes of rock and gas extraordinary claims require extraordinary evidence inconspicuous motes of rock and gas rich in mystery and billions upon billions upon billions upon billions upon billions upon billions upon billions.";
    }
    */
}
