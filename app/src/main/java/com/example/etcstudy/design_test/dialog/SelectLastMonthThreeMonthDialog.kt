package com.example.etcstudy.design_test.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.DialogSelectLastThreeMonthBinding

class SelectLastMonthThreeMonthDialog(context : Context, var lastMonth : Int, val okClickListener : (Int, Int) -> Unit) : Dialog(context) {

    private val binding : DialogSelectLastThreeMonthBinding by lazy { DialogSelectLastThreeMonthBinding.inflate(layoutInflater) }
    private var startMonth : Int = 0
    private lateinit var txtMonthList: MutableList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() = with(binding){

        txtMonthList = mutableListOf(
            txtMonth1, txtMonth2, txtMonth3, txtMonth4, txtMonth5, txtMonth6,
            txtMonth7, txtMonth8, txtMonth9, txtMonth10, txtMonth11, txtMonth12
        )

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnOk.setOnClickListener {
            okClickListener(startMonth, lastMonth)
            dismiss()
        }

        defaultSetting()

    }

    private fun defaultSetting(){
        txtMonthList.forEach{ textView ->
            textView.setOnClickListener {
                selectOnClick(textView)
            }
        }

        binding.txtTitle.text = context.getString(R.string.select_month, lastMonth-2, lastMonth)

        when(lastMonth){
            1 -> txtMonthList[lastMonth - 1].performClick()     // 1월 선택
            2 -> txtMonthList[lastMonth - 1].performClick()     // 2월 선택
            3 -> txtMonthList[lastMonth - 1].performClick()     // 3월 선택
            4 -> txtMonthList[lastMonth - 1].performClick()     // 4월 선택
            5 -> txtMonthList[lastMonth - 1].performClick()     // 5월 선택
            6 -> txtMonthList[lastMonth - 1].performClick()     // 6월 선택
            7 -> txtMonthList[lastMonth - 1].performClick()     // 7월 선택
            8 -> txtMonthList[lastMonth - 1].performClick()     // 8월 선택
            9 -> txtMonthList[lastMonth - 1].performClick()     // 9월 선택
            10 -> txtMonthList[lastMonth - 1].performClick()    // 10월 선택
            11 -> txtMonthList[lastMonth - 1].performClick()    // 11월 선택
            12 -> txtMonthList[lastMonth - 1].performClick()    // 12월 선택
        }
    }

    private fun selectOnClick(textView: TextView){
        removeSetting(txtMonthList)

        textView.setTextColor(context.getColor(R.color.white))
        textView.setBackgroundResource(R.drawable.bg_red_circle)

        lastMonth = textView.tag.toString().toInt()
        if (lastMonth - 2 > 0){
            startMonth = lastMonth - 2
            binding.txtTitle.text = context.getString(R.string.select_month, lastMonth-2, lastMonth)
        } else {
            startMonth = lastMonth - 2 + 12
            binding.txtTitle.text = context.getString(R.string.select_month, lastMonth-2+12, lastMonth)
        }
    }

    private fun removeSetting(txtMonthList: MutableList<TextView>){
        txtMonthList.forEach {
            it.setTextColor(context.getColor(R.color.gray))
            it.background = null
        }

    }

}