package com.example.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    companion object {

        internal const val REQUEST_IMAGE_GET = 1
}
    internal var imageList: ArrayList<ImageData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_add.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_GET)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            val photoUri = data!!.data
            if (photoUri != null) {
                imageList.add(ImageData(photoUri))
                var index=imageList.size-1
                list_layout.addView(createTextView("${imageList[imageList.size-1].fileUri}-${imageList[imageList.size-1].name}", index))
            }
        }

    }
    fun createTextView(imageInfo: String,index:Int): TextView {
        val view = TextView(this)
        view.text = imageInfo
        view.textSize = 24f
        view.tag=index
        view.setOnClickListener {
         val intent = Intent(this,DetailsActivity::class.java)
            intent.putExtra("Key",imageList[index])
            startActivity(intent)

        }

        return view
    }



}
