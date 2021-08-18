package com.example.etcstudy.design_test.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.etcstudy.R
import com.example.etcstudy.databinding.DialogPaymentBinding
import com.example.etcstudy.util.toast

class PaymentDialog(
    context: Context,
    private val year : Int,
    private val month : Int,
    private val buildingTenant : String,
    private val okClickListener : (Long, Long) -> Unit
) : Dialog(context) {

    private val binding : DialogPaymentBinding by lazy { DialogPaymentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setCancelable(false)

        initVies()
    }

    private fun initVies() = with(binding){
        txtTitle.text = context.getString(R.string.payment_year_month, year, month)
        txtDescription.text = buildingTenant

        btnCancel.setOnClickListener { dismiss() }
        btnOk.setOnClickListener {
            if(editRentAmt.text.isNullOrBlank()) {
                it.context.toast("임대료를 입력해주세요")
                return@setOnClickListener
            }

            if(editManageAmt.text.isNullOrBlank()) {
                it.context.toast("관리비를 입력해주세요")
                return@setOnClickListener
            }

            okClickListener(editRentAmt.text.toString().toLong(), editManageAmt.text.toString().toLong())
            dismiss()
        }
    }

}