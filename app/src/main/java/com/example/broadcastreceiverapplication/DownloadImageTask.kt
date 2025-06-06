package com.example.broadcastreceiverapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import java.net.URL

class DownloadImageTask(private val imageView: ImageView) : AsyncTask<String, Void, Bitmap>() {

    private val mainThreadHandler = Handler(Looper.getMainLooper())

    override fun doInBackground(vararg urls: String): Bitmap? {
        val url = urls[0]
        return try {
            val imageUrl = URL(url)
            val connection = imageUrl.openConnection()
            connection.connect()
            val inputStream = connection.getInputStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            null
        }
    }

    override fun onPostExecute(result: Bitmap?) {

                imageView.setImageBitmap(result)
            

    }
}