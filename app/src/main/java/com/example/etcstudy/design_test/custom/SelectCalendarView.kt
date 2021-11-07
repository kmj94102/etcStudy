package com.example.etcstudy.design_test.custom
//
//import android.content.Context
//import android.content.res.TypedArray
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import android.view.View
//import androidx.constraintlayout.widget.ConstraintLayout
//import com.example.etcstudy.R
//import com.example.etcstudy.databinding.CustomCalendarViewBinding
//
//class SelectCalendarView : ConstraintLayout {
//
//    private val binding : CustomCalendarViewBinding by lazy { CustomCalendarViewBinding.inflate(LayoutInflater.from(context)) }
//
//    constructor(context: Context) : super(context){
//        initViews()
//    }
//
//    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
//        initViews()
//        getAttrs(attributeSet)
//    }
//
//    private fun initViews(){
//        addView(binding.root)
//    }
//
//    private fun getAttrs(attributeSet: AttributeSet) {
//        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.SelectCalendarView)
//        setTypeArray(typeArray)
//    }
//
//    private fun setTypeArray(typeArray: TypedArray) {
//        val isComplete = typeArray.getBoolean(R.styleable.SelectCalendarView_selectCalenderIsComplete, false)
//        val isEnable = typeArray.getBoolean(R.styleable.SelectCalendarView_selectCalenderIsEnable, false)
//
//        binding.viewBackground.setBackgroundResource(if(isEnable) R.drawable.ic_calendar2_enable else R.drawable.ic_calendar2)
//        binding.groupCompleted.visibility = if(isComplete) View.VISIBLE else View.GONE
//        binding.groupUnfinished.visibility = if(isComplete) View.GONE else View.VISIBLE
//
//        if(isEnable){
//            binding.groupCompleted.visibility = View.GONE
//            binding.groupUnfinished.visibility = View.GONE
//        }
//    }
//
//    fun setIsEnabled(isEnabled : Boolean){
//        binding.viewBackground.setBackgroundResource(if(isEnabled) R.drawable.ic_calendar2_enable else R.drawable.ic_calendar2)
//
//        if(isEnabled){
//            binding.groupCompleted.visibility = View.GONE
//            binding.groupUnfinished.visibility = View.GONE
//        }
//    }
//
//    fun setIsComplete(isComplete : Boolean){
//        binding.groupCompleted.visibility = if(isComplete) View.VISIBLE else View.GONE
//        binding.groupUnfinished.visibility = if(isComplete) View.GONE else View.VISIBLE
//    }
//
//    fun setMonth(month : String){
//        binding.txtMonth.text = month
//    }
//
//    fun setAmount(receivedAmount : String, remainingAmount : String){
//        binding.txtReceivedAmount.text = receivedAmount
//        binding.txtRemainingAmount.text = remainingAmount
//    }
//
//}