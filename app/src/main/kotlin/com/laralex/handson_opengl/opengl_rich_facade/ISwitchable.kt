package com.laralex.handson_opengl.opengl_rich_facade

sealed interface ISwitchable {
    fun enable()
    fun disable()
    fun isEnabled()
}