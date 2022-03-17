package com.laralex.opengl_minimal_facade

import android.opengl.GLException
import android.opengl.GLU
import android.opengl.GLES30
import com.laralex.util.Logger
import java.lang.StringBuilder
import java.util.ArrayList

object GLError {
    fun exceptionOnErrors(msg: String) {
        val pendingErrors = fetchPendingErrors()
        if (pendingErrors != null) {
            throw GLException(pendingErrors[0], formatErrors(msg, pendingErrors))
        }
    }

    fun warnOnErrors(tag: String?, msg: String) {
        val pendingErrors = fetchPendingErrors()
        if (pendingErrors != null) {
            Logger.w(tag, formatErrors(msg, pendingErrors))
        }
    }

    private fun formatErrors(msg: String, errorCodes: List<Int>): String {
        val builder = StringBuilder(String.format("%s: ", msg))
        for (errorCode in errorCodes) {
            builder.append(String.format("(%d: %s) ", GLU.gluErrorString(errorCode), errorCode))
        }
        return builder.toString()
    }

    private fun fetchPendingErrors() : List<Int>? {
        var errorCode = GLES30.glGetError()
        if (errorCode == GLES30.GL_NO_ERROR) {
            return null
        }
        val errorCodes = ArrayList<Int>()
        while (errorCode != GLES30.GL_NO_ERROR) {
            errorCodes.add(errorCode)
            errorCode = GLES30.glGetError()
        }
        return errorCodes
    }
}