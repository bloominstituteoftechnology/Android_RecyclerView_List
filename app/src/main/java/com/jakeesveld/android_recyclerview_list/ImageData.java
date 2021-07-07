package com.jakeesveld.android_recyclerview_list;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {

    private String name;
    private String imageUri;

    public ImageData(String name, Uri imageUri) {
        this.name = name;
        this.imageUri = imageUri.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImageUri() {
        return Uri.parse(imageUri);
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri.toString();
    }
}
