package com.example.etcstudy.tenant

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout

class CustomCalendarGroup : ConstraintLayout {

    private var oldSelectItem : Int = -1

    constructor(context : Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle : Int) : super(context, attributeSet, defStyle)

    // getSelectedItem 기능 개발 필요
    fun helpSingleSelect(newSelectItem: Int, isSelected : Boolean){
        if (oldSelectItem == newSelectItem) return
        if(oldSelectItem != -1){
            findViewById<CustomCalendarItem>(oldSelectItem).isSelected = false
        }
        if(isSelected) oldSelectItem = newSelectItem
    }

}