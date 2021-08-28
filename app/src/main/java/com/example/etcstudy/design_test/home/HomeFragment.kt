package com.example.etcstudy.design_test.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.transition.addListener
import androidx.core.transition.doOnEnd
import androidx.core.transition.doOnStart
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val binding : FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btn.setOnClickListener {
            animationTest3()
        }

        binding.btn2.setOnClickListener {
            animationTest4()
        }

        binding.btnTest1.setOnClickListener {
            Log.e("+++++", "test1 눌림")
        }

        binding.btnTest2.setOnClickListener {
            Log.e("+++++", "test2 눌림")
        }

        binding.layoutTransition.bringToFront()

    }
    private fun animationTest3(){
        binding.layoutTransition.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            val transition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.transition)
            transition.doOnStart {
                Log.e("++++++", "animation Start")
                binding.layoutTransition.visibility = View.VISIBLE
                binding.btnTest1.isEnabled = false
            }

            TransitionManager.beginDelayedTransition(binding.root, transition)
            val layoutParams = binding.layoutTransition.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.width = binding.cardView.width
            layoutParams.height = binding.cardView.height
            binding.layoutTransition.layoutParams = layoutParams
        }, 100)

    }

    private fun animationTest4(){
        val transition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.transition)
        transition.doOnEnd {
            Log.e("++++++", "animation End")
            binding.layoutTransition.visibility = View.GONE
            binding.btnTest1.isEnabled = true
        }
        TransitionManager.beginDelayedTransition(binding.root, transition)
        val layoutParams = binding.layoutTransition.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.width = binding.view.width
        layoutParams.height = binding.view.height
        binding.layoutTransition.layoutParams = layoutParams
    }

}