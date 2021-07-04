package com.thadocizn.imageviewer.classes;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {

    private String name;
    private String uri;
    private int id;

    public ImageData(String name, String uri, int id) {
        this.name = name;
        this.uri = uri;
        this.id = id;
    }

    public ImageData(String uri, int id) {
        this.uri = uri;
        this.id = id;
    }

    public ImageData(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getUri() {
        return Uri.parse(uri);
    }

    public void setUri(Uri uri) {
        this.uri = uri.toString();
    }
}
