package com.laralex.util

import android.util.Log
import java.util.*

object Logger {
    val TAG = Constants.makeTag("Logger")
    const val LOGGING_LEVEL = Log.DEBUG
    fun a(tag: String?, msgFormat: String?, vararg args: Any?) {
        log(Log.ASSERT, tag, msgFormat, *args)
    }

    fun e(tag: String?, msgFormat: String?, vararg args: Any?) {
        log(Log.ERROR, tag, msgFormat, *args)
    }

    fun w(tag: String?, msgFormat: String?, vararg args: Any?) {
        log(Log.WARN, tag, msgFormat, *args)
    }

    fun i(tag: String?, msgFormat: String?, vararg args: Any?) {
        log(Log.INFO, tag, msgFormat, *args)
    }

    fun d(tag: String?, msgFormat: String?, vararg args: Any?) {
        log(Log.DEBUG, tag, msgFormat, *args)
    }

    fun log(priority: Int, tag: String?, msgFormat: String?, vararg args: Any?) {
        if (LOGGING_LEVEL <= priority) {
            lowLevelLog(priority, tag, msgFormat, *args)
        }
    }

    private fun lowLevelLog(priority: Int, tag: String?, msgFormat: String?, vararg args: Any?) {
        val msg = String.format(Locale.getDefault(), msgFormat!!, *args)
        Log.println(priority, tag, msg)
    }
}