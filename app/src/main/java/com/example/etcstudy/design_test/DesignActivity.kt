package com.example.etcstudy.design_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.core.transition.doOnStart
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityDesignBinding
import com.example.etcstudy.design_test.custom.MyKeyboard
import com.google.android.material.bottomnavigation.BottomNavigationView

class DesignActivity : AppCompatActivity() {

    private lateinit var bottomNavigation : BottomNavigationView
    private lateinit var navController : NavController
    private val binding : ActivityDesignBinding by lazy { ActivityDesignBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bottomNavigation = binding.bottomNavigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)

        navController = findNavController(R.id.navHostFragment)

        bindViews()
    }

    private fun bindViews(){
        navController.addOnDestinationChangedListener { _, _, _ ->
            binding.keyboard.visibility = View.GONE
            bottomNavigation.visibility = View.VISIBLE
        }
    }

    fun showKeyboard(){
        if (binding.keyboard.visibility == View.VISIBLE) return

        val transition = Slide(Gravity.BOTTOM).apply {
            duration = 400
            addTarget(binding.keyboard)
        }
        TransitionManager.beginDelayedTransition(binding.layoutRoot, transition)

        binding.keyboard.visibility = View.VISIBLE
        bottomNavigation.visibility = View.GONE

    }

    fun hideKeyboard(){
        val transition = Slide(Gravity.BOTTOM).apply {
            duration = 400
            addTarget(binding.keyboard)
        }
        TransitionManager.beginDelayedTransition(binding.layoutRoot, transition)
        binding.keyboard.visibility = View.GONE
        bottomNavigation.visibility = View.VISIBLE
    }

    fun getKeyboard() : MyKeyboard = binding.keyboard


    // 참고
    // Fragment에서 사용하게 될 시에 Back을 위한 용도로 사용
    // 화면전환시에 키보드 감추는 작업은 별로도 필요함
    fun onBack(){
        if(navController.currentDestination?.id == R.id.menuHome){
            finish()
        }else{
            navController.popBackStack()
        }
    }

}