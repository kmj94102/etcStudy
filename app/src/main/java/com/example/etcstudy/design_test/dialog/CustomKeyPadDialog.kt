package com.example.etcstudy.design_test.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupWindow
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomKeybordAmountBinding
import com.example.etcstudy.util.removeAmountCommaWon
import com.example.etcstudy.util.toAmountCommaWon

class CustomKeyPadDialog(
    context: Context,
    private val parentView : View,
    private val editText: EditText,
    private val nextFocusDownId : Int
) : View.OnClickListener {

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
        var amountText = editText.text.toString().removeAmountCommaWon()

        when(v?.id){
            binding.btnBack.id -> {
                amountText = if (amountText.length == 1){
                    "0"
                }else {
                    amountText.dropLast(1)
                }
            }
            binding.btnAllDelete.id -> {
                amountText = "0"
            }
            binding.btnNext.id -> {
                popup.dismiss()
            }
            else -> {
                // EditText 최대 길이 15자 기준으로 넘어가면 입력 안함
                if(editText.text.length < 15){
                    val value = v?.tag.toString()
                    amountText += value
                    // 최대 길이 15자 기준 콤마, 원 제외하고 11자까지 입력 가능, 00, 000 버튼의 경우 문제 발생하여 if문 추가
                    if(amountText.length >= 11){
                        amountText = amountText.substring(0, 11)
                    }
                }
            }
        }

        editText.setText(amountText.toLong().toAmountCommaWon())
        editText.setSelection(editText.length())
    }
}