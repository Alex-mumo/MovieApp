package com.example.movieapp.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.movieapp.R
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val bottomNav = findViewById<BottomNavigationMenuView>(R.id.bottom_nav)
        val navControler = navHostFragment.navController
        //bottomNav?.setUpWithNavController(navControler)

        navControler.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.movieFragment){

            }
        }
    }

}