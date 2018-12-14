package com.pulsehrm.alaram

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat


class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {


        val mbuilder = NotificationCompat.Builder(p0!!,"my_app")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alaram Manager")
                .setContentText("Time to Wake Up..")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val nManager = p0.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val id = System.currentTimeMillis()/1000

        nManager.notify(id.toInt(),mbuilder.build())
    }
}

