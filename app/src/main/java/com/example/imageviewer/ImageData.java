package com.example.imageviewer;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {
    private Uri uri;
    private String name;
    public static String TAG = "ImageData";
    private int id;

    ImageData(Uri uri, int id) {
        this.uri = uri;
        name = uri.getLastPathSegment();
        this.id = id;
    }

    public String getUri() {
        return uri.toString();
    }

    public void setUri(String uriString) {
        this.uri = Uri.parse(uriString);
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }
}
