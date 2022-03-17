package com.laralex.opengl_minimal_facade

import android.opengl.GLES32
import android.os.Build
import androidx.annotation.RequiresApi
import com.laralex.util.Logger

object GLCapability {
    val IS_INDEXED_CAPABILITY_SUPPORTED = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    val TAG = com.laralex.opengl_minimal_facade.GLCapability::class.java.name

    enum class Basic(val glCode: Int) {
        GL_BLEND                           (GLES32.GL_BLEND),
        GL_CULL_FACE                       (GLES32.GL_CULL_FACE),
        GL_DEPTH_TEST                      (GLES32.GL_DEPTH_TEST),
        GL_DITHER                          (GLES32.GL_DITHER),
        GL_POLYGON_OFFSET_FILL             (GLES32.GL_POLYGON_OFFSET_FILL),
        GL_SAMPLE_ALPHA_TO_COVERAGE        (GLES32.GL_SAMPLE_ALPHA_TO_COVERAGE),
        GL_SAMPLE_COVERAGE                 (GLES32.GL_SAMPLE_COVERAGE),
        GL_SCISSOR_TEST                    (GLES32.GL_SCISSOR_TEST),
        GL_STENCIL_TEST                    (GLES32.GL_STENCIL_TEST),
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        GL_SAMPLE_MASK                     (GLES32.GL_SAMPLE_MASK),
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        GL_RASTERIZER_DISCARD              (GLES32.GL_RASTERIZER_DISCARD),
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        GL_PRIMITIVE_RESTART_FIXED_INDEX   (GLES32.GL_PRIMITIVE_RESTART_FIXED_INDEX),
        @RequiresApi(Build.VERSION_CODES.N)
        GL_DEBUG_OUTPUT_SYNCHRONOUS        (GLES32.GL_DEBUG_OUTPUT_SYNCHRONOUS),
        @RequiresApi(Build.VERSION_CODES.N)
        GL_DEBUG_OUTPUT                    (GLES32.GL_DEBUG_OUTPUT),
    }

    enum class Indexed(val glCode: Int) {
        // None in OpenGLES 3.2, but some in main standard OpenGL 4.0
    }

    fun enable(capability: Basic) = GLES32.glEnable(capability.glCode)
    fun enable(indexedCapability: Indexed) = GLES32.glEnable(indexedCapability.glCode)
    fun enable(indexedCapability: Indexed, insideCapabilityIndex: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            GLES32.glEnablei(indexedCapability.glCode, insideCapabilityIndex)
        } else {
            Logger.e(TAG, "Changing capability by index is not supported by this Android version")
            enable(indexedCapability)
        }
    }

    fun disable(capability: Basic) = GLES32.glDisable(capability.glCode)
    fun disable(indexedCapability: Indexed) = GLES32.glDisable(indexedCapability.glCode)
    fun disable(indexedCapability: Indexed, insideCapabilityIndex: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            GLES32.glDisablei(indexedCapability.glCode, insideCapabilityIndex)
        } else {
            Logger.e(TAG, "Changing capability by index is not supported by this Android version")
            disable(indexedCapability)
        }
    }

    fun isEnabled(capability: Basic): Boolean = GLES32.glIsEnabled(capability.glCode)
    fun isEnabled(capability: Indexed): Boolean = GLES32.glIsEnabled(capability.glCode)
    fun isEnabled(indexedCapability: Indexed, insideCapabilityIndex: Int): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            GLES32.glIsEnabledi(indexedCapability.glCode, insideCapabilityIndex)
        } else {
            Logger.e(TAG, "Checking enable status of capability by index is not supported by this Android version")
            isEnabled(indexedCapability)
        }
    }

}