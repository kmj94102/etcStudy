package com.example.etcstudy.design_test.custom

import android.view.inputmethod.InputConnection

import android.text.TextUtils

import android.content.Context
import android.util.AttributeSet
import android.util.Log

import android.view.LayoutInflater

import android.util.SparseArray
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CustomKeybordAmountBinding
import com.example.etcstudy.util.removeAmountCommaWon
import com.example.etcstudy.util.toAmountCommaWon


class MyKeyboard : LinearLayout, View.OnClickListener {

    private val binding : CustomKeybordAmountBinding = CustomKeybordAmountBinding.inflate(LayoutInflater.from(context))

    private val keyValues = SparseArray<String>()
    private var inputConnection: InputConnection? = null
    private var editText: EditText?= null

    private var completeListener : (()-> Unit)?= null

    constructor(context: Context) : super(context){
        initViews()
    }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        initViews()
    }


    private fun initViews() {
        addView(binding.root)
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
        keyValues.put(R.id.btnOne, "1")
        keyValues.put(R.id.btnTwo, "2")
        keyValues.put(R.id.btnThree, "3")
        keyValues.put(R.id.btnFour, "4")
        keyValues.put(R.id.btnFive, "5")
        keyValues.put(R.id.btnSix, "6")
        keyValues.put(R.id.btnSeven, "7")
        keyValues.put(R.id.btnEight, "8")
        keyValues.put(R.id.btnNine, "9")
        keyValues.put(R.id.btnZero, "0")
        keyValues.put(R.id.btnHundred, "00")
        keyValues.put(R.id.btnThousand, "000")
    }

    override fun onClick(view: View) {
//        if (inputConnection == null) return
//        if (view.id == R.id.btnBack) {
//            val selectedText = inputConnection!!.getSelectedText(0)
//            if (TextUtils.isEmpty(selectedText)) {
//                inputConnection!!.deleteSurroundingText(1, 0)
//            } else {
//                inputConnection!!.commitText("", 1)
//            }
//        } else if(view.id == R.id.btnAllDelete){
//            inputConnection!!.deleteSurroundingText(100, 0)
//        }else {
//            val value = keyValues[view.id]
//            inputConnection!!.commitText(value, 1)
//        }

        setEditText(view)
    }

    private fun setEditText(view: View){
        var amountText = editText?.text?.toString()?.removeAmountCommaWon() ?: ""

        when(view.id){
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
                completeListener?.invoke()
            }
            else -> {
                // EditText 최대 길이 15자 기준으로 넘어가면 입력 안함
                if(editText?.text?.length?: 0 < 15){
                    val value = view.tag.toString()
                    amountText += value
                    // 최대 길이 15자 기준 콤마, 원 제외하고 11자까지 입력 가능, 00, 000 버튼의 경우 문제 발생하여 if문 추가
                    if(amountText.length >= 11){
                        amountText = amountText.substring(0, 11)
                    }
                }
            }
        }

        editText?.setText(amountText.toLong().toAmountCommaWon())
        editText?.setSelection(editText?.length()?: 0)
    }

    fun setEditText(editText: EditText){
        this.editText = editText
    }

    fun setInputConnection(ic: InputConnection?) {
        inputConnection = ic
    }

    fun setOnCompleteListener(completeListener : () -> Unit){
        this.completeListener = completeListener
    }
}