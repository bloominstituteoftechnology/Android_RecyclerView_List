package com.example.android_recyclerview_list;



import android.net.Uri;

import java.io.Serializable;

public class StoredImage implements Serializable {
    private Uri uriPic;
    private String uriString;


    StoredImage(Uri uriPic, String uriString) {
        this.uriPic = uriPic;
        this.uriString = uriString;
    }

    StoredImage(Uri uriPic) {
        this.uriPic = uriPic;
        uriString = uriPic.toString();
    }

    StoredImage(String uriString) {
        this.uriString = uriString;
        uriPic = Uri.parse(uriString);


    }
    StoredImage(){

    }

    public Uri getUriPic() {
        return uriPic;
    }

    public void setUriPic(Uri uriPic) {
        this.uriPic = uriPic;
    }

    public String getUriString() {
        return uriString;
    }

    public void setUriString(String uriString) {
        this.uriString = uriString;
    }
}

