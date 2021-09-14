package com.example.etcstudy.design_test.custom

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.BaseInputConnection
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.etcstudy.R

class CustomKeyboardAmount : ConstraintLayout {

    private var focusedView : View?= null

    constructor(context : Context) : super(context){
        inflateLayout(context)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        inflateLayout(context)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle : Int) : super(context, attributeSet, defStyle){
        inflateLayout(context)
    }

    private fun inflateLayout(context : Context){
        LayoutInflater.from(context).inflate(R.layout.custom_keybord_amount, this, true)
    }

    private fun bindKeyCodes(){
        KeyCodeMap.values().forEach { keyMap ->
            findViewById<Button>(keyMap.buttonId).setOnClickListener {
                simulateKeyPress(keyMap.keyCode)
            }
        }
    }

    private fun simulateKeyPress(keyCode: Int) {
        if(focusedView == null) return

        val inputConnection = BaseInputConnection(focusedView, true)
        val keyEvent = KeyEvent(KeyEvent.ACTION_DOWN, keyCode)
        inputConnection.sendKeyEvent(keyEvent)
    }

    fun setFocusedView(focusedView : View){
        this.focusedView = focusedView
    }
}

enum class KeyCodeMap(val buttonId : Int, val keyCode : Int) {
    NUM_ONE(R.id.btnOne, KeyEvent.KEYCODE_1),
    NUM_TWO(R.id.btnOne, KeyEvent.KEYCODE_2),
    NUM_THREE(R.id.btnOne, KeyEvent.KEYCODE_3),
    NUM_FOUR(R.id.btnOne, KeyEvent.KEYCODE_4),
    NUM_FIVE(R.id.btnOne, KeyEvent.KEYCODE_5),
    NUM_SIX(R.id.btnOne, KeyEvent.KEYCODE_6),
    NUM_SEVEN(R.id.btnOne, KeyEvent.KEYCODE_7),
    NUM_EIGHT(R.id.btnOne, KeyEvent.KEYCODE_8),
    NUM_NINE(R.id.btnOne, KeyEvent.KEYCODE_9),
    NUM_ZERO(R.id.btnOne, KeyEvent.KEYCODE_0),
    NUM_HUNDRED(R.id.btnOne, KeyEvent.KEYCODE_0),
    NUM_THOUSAND(R.id.btnOne, KeyEvent.KEYCODE_0),
    NUM_BACK(R.id.btnOne, KeyEvent.KEYCODE_BACK);
}