package com.lambdaschool.android_recyclerview_list;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageData implements Serializable {
    private String name;
    private String uri;

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

    public static ArrayList<ImageData> getTestSamples() {
        ArrayList<ImageData> testSamplesAR = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            ImageData dupeToAdd=new ImageData();
            dupeToAdd.setName("Image: "+i);
            dupeToAdd.setUri(Uri.parse("@mipmap/ic_launcher"));
            //dupeToAdd.setUri(Uri.parse("content://com.android.providers.media.documents/document/image%3A94"));
            //dupeToAdd.setUri(Uri.fromFile(new java.io.File("/storage/emulated/0/Download/20171014_161331.jpg")));
            testSamplesAR.add(dupeToAdd);
        }

        return testSamplesAR;
    }
}
