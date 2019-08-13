package com.example.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val myObject = intent.getSerializableExtra("Key") as ImageData
        details_textView.text=myObject.fileUriString
        detailsImageView.setImageURI(myObject.fileUri)
        detailsImageView.setOnClickListener {
            val intent = Intent(this,FullscreenActivity::class.java)
            intent.putExtra("Key2",myObject.fileUriString)
            startActivity(intent)

        }

    }
}
