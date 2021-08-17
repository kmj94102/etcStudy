package com.example.etcstudy.design_test.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomRentalStatusViewBinding


open class RentalStatusView : ConstraintLayout{

    private val binding = CustomRentalStatusViewBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context) : super(context){
        initViews()
    }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        initViews()
        getAttrs(attributeSet)
    }

    private fun initViews(){
        addView(binding.root)
    }

    private fun getAttrs(attributeSet: AttributeSet){
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.RentalStatusView)
        setTypeArray(typeArray)
    }

    private fun setTypeArray(typeArray: TypedArray) {
        val monthText = typeArray.getString(R.styleable.RentalStatusView_monthText)
        val backgroundRes = typeArray.getResourceId(R.styleable.RentalStatusView_backgroundRes, R.drawable.bg_sky_blue_round_7)
        val textColorRes = typeArray.getResourceId(R.styleable.RentalStatusView_textColorRes, R.color.sky_blue)
        val dotColorRes = typeArray.getResourceId(R.styleable.RentalStatusView_dotColorRes, R.color.sky_blue)

        binding.txtMonth.text = monthText
        binding.txtMonth.setTextColor(ContextCompat.getColor(context, textColorRes))
        binding.layoutBackground.setBackgroundResource(backgroundRes)
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
        binding.layoutBackground.setBackgroundResource(backgroundRes)
    }

    fun setDotColor(colorRes: Int){
        binding.viewDot.backgroundTintList = ContextCompat.getColorStateList(context, colorRes)
    }
}
