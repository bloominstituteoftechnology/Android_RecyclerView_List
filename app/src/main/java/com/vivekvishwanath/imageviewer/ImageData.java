package com.vivekvishwanath.imageviewer;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {

    private String imageName,stringUri;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(int index) {
        imageName = "Image: " + index;
    }

    public Uri getUri() {
        return Uri.parse(stringUri);
    }

    public void setUri(Uri uri) {
        stringUri = uri.toString();
    }
}
