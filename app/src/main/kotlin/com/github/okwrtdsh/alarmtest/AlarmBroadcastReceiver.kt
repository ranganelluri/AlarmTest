package com.github.okwrtdsh.alarmtest

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri


class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        (context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(
            intent!!.getIntExtra("notificationId", 0),
            Notification.Builder(context).apply {
                setSmallIcon(android.R.drawable.ic_dialog_info)


                var uri = Uri.parse("android.resource://"+context!!.packageName+"/"+R.raw.hanuman_chalisa_sp_balasubramanyam)

                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

                var r = RingtoneManager.getRingtone(context,uri)

                r.play()

                setContentTitle("Alarm Notification")
                setSmallIcon(R.drawable.ic_alarm_black_24dp)
                setContentText(intent.getCharSequenceExtra("reminder"))
                setWhen(System.currentTimeMillis())
                setPriority(Notification.PRIORITY_DEFAULT)
                setAutoCancel(true)
                setContentIntent(PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0))
            }.build()
        )
    }
}