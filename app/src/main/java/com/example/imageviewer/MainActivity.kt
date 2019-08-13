package com.example.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    companion object {

        internal const val REQUEST_IMAGE_GET = 1
}
    internal var imageList: ArrayList<ImageData> = ArrayList()
    private val adapter = ImageListAdapter(imageList)

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

        list_layout.setHasFixedSize(false)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list_layout.layoutManager = manager
        list_layout.adapter = adapter
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            val photoUri = data!!.data
            if (photoUri != null) {
                imageList.add(ImageData(photoUri))
                adapter.notifyDataSetChanged()

            }
        }

    }
}
