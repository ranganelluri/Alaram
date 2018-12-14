package com.pulsehrm.alaram

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val broadcastIntent = Intent(this,AlarmBroadcastReceiver::class.java)

    val pIntent = PendingIntent.getBroadcast(this,0,broadcastIntent,0)

        val aManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        setAlarm.setOnClickListener {
            aManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5000,pIntent)

            Toast.makeText(this,"Alaram Set to 5 sec",Toast.LENGTH_LONG).show()
        }

    }

    private fun dateForAlaram():Long{
        val calendar = Calendar.getInstance()

        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.SECOND,30)
        return calendar.timeInMillis
    }
}
