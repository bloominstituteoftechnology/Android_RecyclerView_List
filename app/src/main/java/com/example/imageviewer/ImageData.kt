package com.example.imageviewer

import android.net.Uri
import java.io.Serializable

class ImageData(fullPhotoUri: Uri) : Serializable {
    var name: String
    val fileUriString: String

    val fileUri: Uri
        get() = Uri.parse(fileUriString)
    val fileName:String
        get() = name


    init {
        this.fileUriString = fullPhotoUri.toString()
        val path = fullPhotoUri.path!!.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        this.name = path[path.size - 1]
    }

}