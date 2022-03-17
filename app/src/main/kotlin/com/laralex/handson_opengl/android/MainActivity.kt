package com.laralex.handson_opengl.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.laralex.handson_opengl.R
import com.laralex.opengl_minimal_facade.GLCapability
import com.laralex.opengl_minimal_facade.GLError

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = MainActivity::class.java.name
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        GLCapability.enable(GLCapability.Basic.GL_BLEND)
        PopupHelper.toast(this, "%s %s", "GL_BLEND", GLCapability.isEnabled(GLCapability.Basic.GL_BLEND))
        GLError.exceptionOnErrors("Bad OpenGl configuration")
    }

    fun setupBottomNavigation() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById( R.id.bottom_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavView.setupWithNavController(navController)
    }
}