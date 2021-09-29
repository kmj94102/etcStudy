package com.example.etcstudy.design_test.home

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.transition.doOnEnd
import androidx.core.transition.doOnStart
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentHomeBinding
import com.example.etcstudy.design_test.DesignActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class HomeFragment : Fragment(), View.OnFocusChangeListener, View.OnClickListener {

    private val binding : FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private var isKeyboardVisible = false

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

//        binding.editText.apply {
//            setTextIsSelectable(true)
//            showSoftInputOnFocus = false
//            onFocusChangeListener = focusChangeListener
//            setOnClickListener {
//                CustomKeyPadDialog(requireActivity(), binding.root, this, this.nextFocusDownId).show()
//            }
//        }
//
//        binding.editText2.apply {
//            setTextIsSelectable(true)
//            showSoftInputOnFocus = false
//            onFocusChangeListener = focusChangeListener
//            setOnClickListener {
//                CustomKeyPadDialog(requireActivity(), binding.root, this, this.nextFocusDownId).show()
//            }
//        }

        binding.editText0.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText0.setTextIsSelectable(true)
        binding.editText1.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText1.setTextIsSelectable(true)
        binding.editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText.setTextIsSelectable(true)
        binding.editText2.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText2.setTextIsSelectable(true)

        Handler(Looper.getMainLooper()).postDelayed({
            val ic = binding.editText0.onCreateInputConnection(EditorInfo())
            (activity as? DesignActivity)?.getKeyboard()?.apply {
                setInputConnection(ic)
                setEditText(binding.editText0)
                setOnCompleteListener {
                    (activity as? DesignActivity)?.hideKeyboard()
                }
            }
        }, 300)

        binding.editText0.onFocusChangeListener = this
        binding.editText1.onFocusChangeListener = this
        binding.editText2.onFocusChangeListener = this
        binding.editText.onFocusChangeListener = this
        binding.editText0.setOnClickListener(this)
        binding.editText1.setOnClickListener(this)
        binding.editText2.setOnClickListener(this)
        binding.editText.setOnClickListener(this)
        binding.root.onFocusChangeListener = this

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(isKeyboardVisible){
                    (activity as? DesignActivity)?.hideKeyboard()
                    isKeyboardVisible = false
                }else{
                    (activity as? DesignActivity)?.onBack()
                }
            }
        })
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

//    private val focusChangeListener = View.OnFocusChangeListener{ v, hasFocus ->
//        if(!hasFocus) return@OnFocusChangeListener
//
//        CustomKeyPadDialog(requireActivity(), binding.root, v as EditText, v.nextFocusDownId).show()
////        binding.keyPadView.setFocusedView(v)
////
//        val imm = requireActivity().getSystemService(InputMethodManager::class.java)
////        imm.hideSoftInputFromWindow(v.windowToken, 0)
//    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(view is EditText && hasFocus){
            view.showSoftInputOnFocus = false
            (activity as? DesignActivity)?.apply {
                showKeyboard()
                isKeyboardVisible = true
                getKeyboard().setEditText(view)
            }
        }else{
            (activity as? DesignActivity)?.hideKeyboard()
            isKeyboardVisible = false
        }
    }

    override fun onClick(view: View?) {
        if(view is EditText){
            view.showSoftInputOnFocus = false
            (activity as? DesignActivity)?.apply{
                showKeyboard()
                isKeyboardVisible = true
                getKeyboard().setEditText(view)
            }
        }
    }

    override fun onDestroy() {
        (activity as? DesignActivity)?.hideKeyboard()
        super.onDestroy()
    }

}