package com.laralex.util

import java.util.*

object Constants {
    const val BASE_TAG = "HandsOnOpenGL"

    /**
     * Make a full tag of a package
     * @param sub_tag string
     * @return full tag string merged from [Constants.BASE_TAG] and given arg
     */
    fun makeTag(sub_tag: String?): String {
        return String.format(Locale.getDefault(), "%s_%s", BASE_TAG, sub_tag)
    }
}