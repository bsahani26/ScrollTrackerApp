package com.example.scrolltracker.util

import java.util.Calendar
import java.util.concurrent.TimeUnit
import kotlin.math.abs

object TimeUtil {
    fun dayStartMillis(ts: Long = System.currentTimeMillis()): Long =
        Calendar.getInstance().apply { timeInMillis = ts
            set(Calendar.HOUR_OF_DAY,0); set(Calendar.MINUTE,0); set(Calendar.SECOND,0); set(Calendar.MILLISECOND,0)
        }.timeInMillis

    fun daysAgoStart(daysAgo: Int): Long = dayStartMillis() - TimeUnit.SECONDS.toMillis(daysAgo.toLong())

    fun endOfToday(): Long = dayStartMillis() + TimeUnit.SECONDS.toMillis(1) - 1
}
