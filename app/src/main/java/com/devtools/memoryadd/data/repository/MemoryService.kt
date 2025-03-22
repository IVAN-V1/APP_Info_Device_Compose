package com.devtools.memoryadd.data.repository

import android.app.ActivityManager
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MemoryService {

    suspend fun getRAMInfo(context: Context): Pair<Pair<Double, Double>, Pair<Double, Double>> {

        return withContext(Dispatchers.IO) {
            val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val memoryInfo = ActivityManager.MemoryInfo()
            activityManager.getMemoryInfo(memoryInfo)

            val totalRamGB = String.format("%.1f", memoryInfo.totalMem / (1024 * 1024 * 1024).toDouble()).toDouble()
            val availableRam = String.format("%.1f", memoryInfo.availMem / (1024 * 1024).toDouble()).toDouble()

            val usedPercentage = String.format("%.2f", (availableRam / (totalRamGB * 1024)) * 100).toDouble()
            val percentageFree = String.format("%.2f", 100.0 - usedPercentage).toDouble()

            Pair(Pair(totalRamGB, availableRam), Pair(percentageFree, usedPercentage))

        }
    }
}



