package com.example.etcstudy.design_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CellRentalStatusBinding
import com.example.etcstudy.design_test.PaymentStatus.*
import com.example.etcstudy.design_test.custom.RentalStatusView

class RentalStatusAdapter : ListAdapter<RentalStatusResult, RentalStatusAdapter.RentalStatusViewHolder>(diffUtil) {

    inner class RentalStatusViewHolder(val binding : CellRentalStatusBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(result: RentalStatusResult){
            binding.txtHo.text = result.ho
            binding.txtTenant.text = result.tenantName
            setRentalStatusView(binding.txtStartMonth, result.startMonth, result.startMonthStatus)
            setRentalStatusView(binding.txtMiddleMonth, result.middleMonth, result.middleMonthStatus)
            setRentalStatusView(binding.txtEndMonth, result.endMonth, result.endMonthStatus)
        }
    }

    private fun setRentalStatusView(rentalStatusView: RentalStatusView, month : String, status : Rental){
        rentalStatusView.setMonth(month)
        when(status.status){
            FULL_PAYMENT -> {
                rentalStatusView.setTextColor(R.color.sky_blue)
                rentalStatusView.setDotColor(R.color.sky_blue)
                rentalStatusView.setBackground(R.drawable.bg_sky_blue_round_7)
            }
            NON_PAYMENT -> {
                rentalStatusView.setTextColor(R.color.red)
                rentalStatusView.setDotColor(R.color.red)
                rentalStatusView.setBackground(R.drawable.bg_red_round_7)
            }
            PAYMENT_DUE -> {
                rentalStatusView.setTextColor(R.color.dark_yellow)
                rentalStatusView.setDotColor(R.color.yellow)
                rentalStatusView.setBackground(R.drawable.bg_yellow_round_7)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalStatusViewHolder =
        RentalStatusViewHolder(CellRentalStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RentalStatusViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RentalStatusResult>(){
            override fun areItemsTheSame(oldItem: RentalStatusResult, newItem: RentalStatusResult) = oldItem == newItem

            override fun areContentsTheSame(oldItem: RentalStatusResult, newItem: RentalStatusResult) = oldItem.ho == newItem.ho

        }
    }

}