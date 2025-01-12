package com.example.broadcastreceiverapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {



    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeOn = intent?.getBooleanExtra("state", false)
        Toast.makeText(context, if (isAirplaneModeOn == true) "Airplane Mode ON" else "Airplane Mode OFF", Toast.LENGTH_SHORT).show()

    }
}