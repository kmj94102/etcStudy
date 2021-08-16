package com.example.etcstudy.design_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityDesignBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DesignActivity : AppCompatActivity() {

    private lateinit var bottomNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)

    }
}