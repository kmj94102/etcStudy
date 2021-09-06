package com.example.etcstudy.design_test.custom

import android.content.Context
import android.text.Html
import android.util.AttributeSet

class CustomTextView : androidx.appcompat.widget.AppCompatTextView {

    constructor(context : Context) : super(context){
        initViews()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        initViews()
    }

    private fun initViews(){
        text = Html.fromHtml("", 0)
    }

}