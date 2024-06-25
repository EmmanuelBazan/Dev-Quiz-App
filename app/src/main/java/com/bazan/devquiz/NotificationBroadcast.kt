package com.bazan.devquiz

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "1"
const val TITLE_EXTRA = "titleExtra"
const val MESSAGE_EXTRA = "messageExtra"
class NotificationBroadcast : BroadcastReceiver() {
//    override fun onReceive(context: Context, intent: Intent?) {
//        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
//            .build()
//
//        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        manager.notify(NOTIFICATION_ID, notification)
//    }

    override fun onReceive(context: Context, intent: Intent) {
        // Crear el canal de notificación
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val name = "My Notification Channel"
            val descriptionText = "Channel for my notifications"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Crear la notificación
        val notificationIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.levels_icon)
            .setContentTitle("Scheduled Notification")
            .setContentText("This is your scheduled notification.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(1, builder.build())
        }
    }

}