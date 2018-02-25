package com.yazan.it.fbpro

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_upload.*
import java.io.ByteArrayOutputStream

class UploadAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        imageView.setOnClickListener {
            var i=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,123)
        }

        button2.setOnClickListener {

            imageView.isDrawingCacheEnabled=true
            imageView.buildDrawingCache()

            var bmp=imageView.getDrawingCache()
            var boas=ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.JPEG,100,boas)
            var data=boas.toByteArray()


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var bmp=data?.extras?.get("data") as Bitmap
        imageView.setImageBitmap(bmp)

    }


}









