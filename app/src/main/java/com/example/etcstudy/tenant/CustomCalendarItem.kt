package com.example.etcstudy.tenant

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomCalendarItemBinding

class CustomCalendarItem : ConstraintLayout {

    private val binding = CustomCalendarItemBinding.inflate(LayoutInflater.from(context))

    constructor(context : Context) : super(context){
        initViews()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        initViews()
        getAttrs(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle : Int) : super(context, attributeSet, defStyle){
        initViews()
        getAttrs(attributeSet)
    }

    private fun initViews(){
        addView(binding.root)
    }

    private fun getAttrs(attributeSet: AttributeSet){
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomCalendarItem)
        setTypeArray(typeArray)
    }

    private fun setTypeArray(typeArray: TypedArray) {
        val dateText = typeArray.getString(R.styleable.CustomCalendarItem_date)
        val isSelected = typeArray.getBoolean(R.styleable.CustomCalendarItem_isSelected, false)

        binding.textViewDate.text = dateText
        setSelected(isSelected)

    }

    override fun setSelected(selected: Boolean){
        binding.viewBackground.setBackgroundResource(if (selected) R.drawable.bg_circle_main_mint_trans else android.R.color.transparent)

        (parent as? CustomCalendarGroup)?.helpSingleSelect(this.id, selected)

    }

}