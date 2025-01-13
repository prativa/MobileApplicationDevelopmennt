package com.example.broadcastreceiverapplication

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    private lateinit var statusTextView: TextView
    private lateinit var airplaneModeReceiver: AirplaneModeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        statusTextView = findViewById(R.id.statusTextView)

        // Create and start a background thread
        val backgroundThread = Thread {
            // Simulate a time-consuming task (e.g., network request or heavy computation)
            Thread.sleep(2000)  // 2-second delay to simulate background work

            // Perform background task
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


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
    }
}