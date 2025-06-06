package com.example.broadcastreceiverapplication

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    private lateinit var statusTextView: TextView
    private lateinit var imageViewUrl: ImageView
    private lateinit var airplaneModeReceiver: AirplaneModeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        statusTextView = findViewById(R.id.statusTextView)
        imageViewUrl = findViewById(R.id.imageViewUrl)

        // Create and start a background thread
        val backgroundThread = Thread {
            Thread.sleep(2000)  // 2-second delay to simulate background work
            val result = "Thread Task Completed"

            // Now update the UI on the main thread
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.post {
                statusTextView.text = result  // Update the TextView with the result
            }
        }

        backgroundThread.start()


        // Create a Runnable for the background task
        val backgroundRunnable = Runnable {
            // Simulate a time-consuming task (e.g., network request or heavy computation)
            Thread.sleep(2000)  // 2-second delay to simulate background work

            // Task result after background work
            val result = "Task Completed from runnable"

            // Now update the UI on the main thread
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.post {
                statusTextView.text = result  // Update the TextView with the result
            }
        }

        // Create and start a background thread to run the Runnable
        val backgroundThreadFromRunnnnable = Thread(backgroundRunnable)
        backgroundThreadFromRunnnnable.start()  // Start the background thread


        val downloadImageTask = DownloadImageTask(imageViewUrl)


        downloadImageTask.execute("https://assets-cdn.ekantipur.com/uploads/source/ads/road-block1180x715px-0312025013226.jpg")

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
    }
}