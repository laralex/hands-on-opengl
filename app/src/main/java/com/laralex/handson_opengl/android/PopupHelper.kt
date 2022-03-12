/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.laralex.handson_opengl.android

import com.laralex.handson_opengl.android.SnackbarHelper
import android.app.Activity
import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
import java.util.*

class PopupHelper {
    private var mSnackbarHelper: SnackbarHelper? = null

    constructor(maxSnackbarLines: Int) {
        PopupHelper(maxSnackbarLines, null)
    }

    constructor(maxSnackbarLines: Int, snackbarView: View?) {
        mSnackbarHelper = SnackbarHelper()
        mSnackbarHelper!!.setMaxLines(maxSnackbarLines)
        mSnackbarHelper!!.setParentView(snackbarView)
    }

    fun snackbarError(activity: Activity?, msgFormat: String?, vararg args: Any?) {
        val msg = String.format(Locale.getDefault(), msgFormat!!, *args)
        mSnackbarHelper!!.showError(activity!!, msg, Snackbar.LENGTH_LONG)
    }

    fun snackbarMessage(activity: Activity?, msgFormat: String?, vararg args: Any?) {
        val msg = String.format(Locale.getDefault(), msgFormat!!, *args)
        mSnackbarHelper!!.showMessage(activity!!, msg, Snackbar.LENGTH_LONG)
    }

    fun snackbarMessageDismiss(activity: Activity?, msgFormat: String?, vararg args: Any?) {
        val msg = String.format(Locale.getDefault(), msgFormat!!, *args)
        mSnackbarHelper!!.showMessageWithDismiss(activity!!, msg, Snackbar.LENGTH_LONG)
    }

    fun snackbarHide(activity: Activity?) {
        mSnackbarHelper!!.hide(activity!!)
    }

    companion object {
        fun toast(context: Context?, msgFormat: String?, vararg args: Any?) {
            val msg = String.format(Locale.getDefault(), msgFormat!!, *args)
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}