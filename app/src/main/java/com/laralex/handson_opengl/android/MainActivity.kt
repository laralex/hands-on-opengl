package com.laralex.handson_opengl.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.laralex.handson_opengl.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById( R.id.bottom_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val configuration = AppBarConfiguration(setOf(
            R.id.pane_render, R.id.pane_cpu, R.id.pane_gpu, R.id.pane_render, R.id.pane_settings
        ))
        bottomNavView.setupWithNavController(navController)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }
}