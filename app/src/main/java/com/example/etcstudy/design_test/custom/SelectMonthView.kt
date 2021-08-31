package com.example.etcstudy.design_test.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomSelectMonthBinding

class SelectMonthView : ConstraintLayout {

    private val binding = CustomSelectMonthBinding.inflate(LayoutInflater.from(context))

    constructor(context : Context) : super(context){
        initViews()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        initViews()
        getAttrs(attributeSet)
    }

    private fun initViews(){
        addView(binding.root)
    }

    private fun getAttrs(attributeSet: AttributeSet) {
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.SelectMonthView)
        setTypeArray(typeArray)
    }

    private fun setTypeArray(typeArray: TypedArray) {
        val monthText = typeArray.getString(R.styleable.SelectMonthView_selectMonthMonthText)
        val backgroundRes = typeArray.getResourceId(R.styleable.SelectMonthView_selectMonthBackgroundRes, android.R.color.transparent)
        val textColorRes = typeArray.getResourceId(R.styleable.SelectMonthView_selectMonthTextColorRes, R.color.black)
        val dotColorRes = typeArray.getResourceId(R.styleable.SelectMonthView_selectMonthDotColorRes, R.color.sky_blue)

        binding.txtMonth.text = monthText
        binding.txtMonth.setTextColor(ContextCompat.getColor(context, textColorRes))
        binding.layoutRoot.setBackgroundResource(backgroundRes)
        binding.viewDot.backgroundTintList = ContextCompat.getColorStateList(context, dotColorRes)

        typeArray.recycle()
    }

    fun setMonth(month : String){
        binding.txtMonth.text = month
    }

    fun setTextColor(colorRes : Int){
        binding.txtMonth.setTextColor(ContextCompat.getColor(context, colorRes))
    }

    fun setBackground(backgroundRes : Int){
        binding.layoutRoot.setBackgroundResource(backgroundRes)
    }

    fun setDotColor(colorRes: Int){
        binding.viewDot.backgroundTintList = ContextCompat.getColorStateList(context, colorRes)
    }
}