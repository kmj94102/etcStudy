package com.example.etcstudy.design_test.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomCalendarViewBinding

class MonthlyCalendarView : ConstraintLayout {

    private val binding : CustomCalendarViewBinding = CustomCalendarViewBinding.inflate(LayoutInflater.from(context))

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
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.MonthlyCalendarView)
        setTypeArray(typeArray)
    }

    private fun setTypeArray(typeArray: TypedArray) {
        val isContentsVisible = typeArray.getBoolean(R.styleable.MonthlyCalendarView_isContentsVisible, false)
        val isComplete = typeArray.getBoolean(R.styleable.MonthlyCalendarView_isComplete, false)
        val isEnable = typeArray.getBoolean(R.styleable.MonthlyCalendarView_isEnable, true)

        if(isEnable){
            binding.viewBackground.setBackgroundResource(R.drawable.ic_calendar2)
            binding.groupCompleted.isVisible = isComplete
            binding.groupContents.isVisible = isContentsVisible
        }else{
            binding.viewBackground.setBackgroundResource(R.drawable.ic_calendar2_enable)
            binding.groupCompleted.visibility = View.GONE
            binding.groupContents.visibility = View.GONE
        }
    }

    fun setMonth(month : String){
        binding.txtMonth.text = month
    }

    fun setEnable(isEnable : Boolean){
        if(isEnable){
            binding.viewBackground.setBackgroundResource(R.drawable.ic_calendar2)
        }else{
            binding.viewBackground.setBackgroundResource(R.drawable.ic_calendar2_enable)
            binding.groupCompleted.visibility = View.GONE
            binding.groupContents.visibility = View.GONE
        }
    }

    fun setComplete(isComplete : Boolean){
        binding.groupCompleted.isVisible = isComplete
        binding.groupContents.isVisible = false
    }

    fun setContents(isContentsVisible : Boolean, receivedAmount : String?, remainingAmount: String?){
        binding.groupContents.isVisible = isContentsVisible
        binding.txtReceivedAmount.text = receivedAmount
        binding.txtRemainingAmount.text = remainingAmount
    }

}