package com.example.etcstudy.design_test.home

import android.annotation.SuppressLint
import android.graphics.Color
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
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.transition.addListener
import androidx.core.transition.doOnEnd
import androidx.core.transition.doOnStart
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentHomeBinding
import com.example.etcstudy.design_test.dialog.CustomKeyPadDialog
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

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

        setChart()

//        binding.editText.onFocusChangeListener = focusChangeListener

        binding.btnTest.setOnClickListener {
            CustomKeyPadDialog(requireActivity(), binding.root, binding.editText).show()
        }

        binding.editText.apply {
            setTextIsSelectable(true)
            showSoftInputOnFocus = false
            onFocusChangeListener = focusChangeListener
            setOnClickListener {
                CustomKeyPadDialog(requireActivity(), binding.root, binding.editText).show()
            }
        }

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

    private fun setChart() = with(binding.chart){
        val entries = ArrayList<Entry>()

        (0..10).forEach { i ->
            val value = Math.random() * 10
            entries.add(Entry(i.toFloat(), value.toFloat()))
        }

        val set = LineDataSet(entries, "Data Set1")
        val dataSets : ArrayList<ILineDataSet> = arrayListOf(set)

        val data = LineData(dataSets)

        set.color = Color.BLACK
        set.setCircleColor(Color.RED)

        setData(data)
        axisLeft.setDrawGridLines(false)
        axisLeft.setDrawLabels(false)
        axisLeft.setDrawAxisLine(false)
        axisRight.setDrawGridLines(false)
        axisRight.setDrawLabels(false)
        axisRight.setDrawAxisLine(false)
        xAxis.setDrawGridLines(false)
        xAxis.setDrawLabels(false)
        xAxis.setDrawAxisLine(false)
        legend.isEnabled = false
        description.isEnabled = false
        setTouchEnabled(false)
        isDoubleTapToZoomEnabled = false

        animateY(1400, Easing.EaseInOutQuad)
        animate()

    }

    private val focusChangeListener = View.OnFocusChangeListener{ v, hasFocus ->
        if(!hasFocus) return@OnFocusChangeListener

        CustomKeyPadDialog(requireActivity(), binding.root, binding.editText).show()
//        binding.keyPadView.setFocusedView(v)
//
        val imm = requireActivity().getSystemService(InputMethodManager::class.java)
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }

}