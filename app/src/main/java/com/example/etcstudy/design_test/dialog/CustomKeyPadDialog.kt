package com.example.etcstudy.design_test.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupWindow
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomKeybordAmountBinding

class CustomKeyPadDialog(context: Context, private val parentView : View, private val editText: EditText) : View.OnClickListener {

    private val popup : PopupWindow
    private val binding : CustomKeybordAmountBinding = CustomKeybordAmountBinding.inflate(LayoutInflater.from(context))

    init {
        popup = PopupWindow(binding.root, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        popup.isTouchable = true
        popup.isFocusable = true
        popup.isOutsideTouchable = true
        popup.animationStyle = R.style.popup_window_animation

        binding.btnOne.setOnClickListener(this)
        binding.btnTwo.setOnClickListener(this)
        binding.btnThree.setOnClickListener(this)
        binding.btnFour.setOnClickListener(this)
        binding.btnFive.setOnClickListener(this)
        binding.btnSix.setOnClickListener(this)
        binding.btnSeven.setOnClickListener(this)
        binding.btnEight.setOnClickListener(this)
        binding.btnNine.setOnClickListener(this)
        binding.btnZero.setOnClickListener(this)
        binding.btnHundred.setOnClickListener(this)
        binding.btnThousand.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)
        binding.btnAllDelete.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
    }

    private fun isVisible() = popup.isShowing

    fun show(){
        if(isVisible()) return

        popup.showAtLocation(parentView, Gravity.BOTTOM, 0, 0)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            binding.btnBack.id -> {
                if(editText.text.isNullOrEmpty().not()){
                    editText.setText(editText.text.toString().dropLast(1))
                }
            }
            binding.btnAllDelete.id -> {
                editText.setText("")
            }
            binding.btnNext.id -> {
                popup.dismiss()
            }
            else -> {
                val value = v?.tag.toString()
                editText.text = editText.text.append(value)
            }
        }

        editText.setSelection(editText.length())
    }
}