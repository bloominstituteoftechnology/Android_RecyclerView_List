package com.example.joshh.imageviewer;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {
    private String name;
    private String uri;

    public ImageData(String name, String uri){
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public Uri getUri() {
        return Uri.parse(uri);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(Uri uri) {
        this.uri = uri.toString();
    }
}
