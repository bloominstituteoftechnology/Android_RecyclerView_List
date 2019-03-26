package com.example.imageviewer;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {
    private Uri uri;
    private String name;

    ImageData(Uri uri) {
        this.uri = uri;
        name = uri.getLastPathSegment();
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
}
