package com.example.jacob.imageviewer;

import android.net.Uri;

import java.io.Serializable;
import java.net.URI;

public class ImageData implements Serializable {
    private String imageStringUri;
    private String imageName;

    public ImageData(Uri imageUri, String imageName) {
        this.imageStringUri = imageUri.toString();
        this.imageName = imageName;
    }

    public Uri getImageUri() {
        return Uri.parse(imageStringUri);
    }

    public void setImageUri(String imageUri) {
        this.imageStringUri = imageUri.toString();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
