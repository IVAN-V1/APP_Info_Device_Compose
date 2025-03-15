package com.devtools.memoryadd.data.repository

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.ServiceCompat.START_STICKY

class MemoryService {


    fun getRAMInfo(context: Context, callback: (Pair<Double, Double>) -> Unit) {
        val handler = android.os.Handler(android.os.Looper.getMainLooper())

        val runnable = object : Runnable {
            override fun run() {
                val activityManager =
                    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                val memoryInfo = ActivityManager.MemoryInfo()
                activityManager.getMemoryInfo(memoryInfo)

                val totalRam = memoryInfo.totalMem / (1024 * 1024).toDouble() // Total RAM in MB
                val availableRam =
                    memoryInfo.availMem / (1024 * 1024).toDouble() // Available RAM in MB

                // Aquí puedes actualizar la UI o hacer algo con los valores obtenidos
                Log.d("MemoryService", "RAM Total: $totalRam MB, RAM Disponible: $availableRam MB")

                // Llama al callback con los valores actualizados
                callback(Pair(totalRam, availableRam))

                handler.postDelayed(this, 1000) // Repite cada segundo
            }
        }
        handler.post(runnable)
    }






}