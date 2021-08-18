package com.example.etcstudy.design_test.rental_management2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CellRentalStatusBinding
import com.example.etcstudy.databinding.CellRentalTitleBinding
import com.example.etcstudy.design_test.*
import com.example.etcstudy.design_test.custom.RentalStatusView
import com.example.etcstudy.design_test.dialog.PaymentDialog
import com.example.etcstudy.util.setLayoutMarginBottom
import com.example.etcstudy.util.setLayoutMarginTop
import kotlin.math.roundToInt

class RentalStatusAdapter : ListAdapter<RentalStatusType, RecyclerView.ViewHolder>(diffUtil) {

    inner class TitleViewHolder(val binding : CellRentalTitleBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : RentalStatusTitle){
            binding.viewTop.isVisible = adapterPosition != 0

            binding.txtHo.text = item.buildingName
            setViewChevronBackground(binding.viewChevron, item.isOpened)
            binding.root.setOnClickListener {
                item.isOpened = item.isOpened.not()
                setViewChevronBackground(binding.viewChevron, item.isOpened)
            }
        }
    }

    private fun setViewChevronBackground(view : View, isOpened : Boolean){
        view.setBackgroundResource(if (isOpened) R.drawable.ic_chevron_up_bold else R.drawable.ic_chevron_down_bold)
    }

    inner class DetailViewHolder(val binding : CellRentalStatusBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: RentalStatusDetail){

            if(currentList[adapterPosition - 1].type == RentalStatusType.TYPE_TITLE){
                binding.layoutRentalStatus.setLayoutMarginTop(22f)
                binding.layoutRentalStatus.setLayoutMarginBottom(11f)
            }
            else if(adapterPosition < currentList.size && currentList[adapterPosition + 1].type == RentalStatusType.TYPE_TITLE){
                binding.layoutRentalStatus.setLayoutMarginTop(11f)
                binding.layoutRentalStatus.setLayoutMarginBottom(22f)
            }else{
                binding.layoutRentalStatus.setLayoutMarginTop(11f)
                binding.layoutRentalStatus.setLayoutMarginBottom(11f)
            }

            binding.txtHo.text = item.ho
            binding.txtTenant.text = item.tenantName
            setRentalStatusView(binding.txtStartMonth, item.startMonth, item.startMonthStatus)
            setRentalStatusView(binding.txtMiddleMonth, item.middleMonth, item.middleMonthStatus)
            setRentalStatusView(binding.txtEndMonth, item.endMonth, item.endMonthStatus)
        }
    }

    private fun setRentalStatusView(rentalStatusView: RentalStatusView, month : String, status : Rental){
        rentalStatusView.setMonth(month)
        when(status.status){
            PaymentStatus.FULL_PAYMENT -> {
                rentalStatusView.setTextColor(R.color.sky_blue)
                rentalStatusView.setDotColor(R.color.sky_blue)
                rentalStatusView.setBackground(R.drawable.bg_sky_blue_round_7)
            }
            PaymentStatus.NON_PAYMENT -> {
                rentalStatusView.setTextColor(R.color.red)
                rentalStatusView.setDotColor(R.color.red)
                rentalStatusView.setBackground(R.drawable.bg_red_round_7)
            }
            PaymentStatus.PAYMENT_DUE -> {
                rentalStatusView.setTextColor(R.color.dark_yellow)
                rentalStatusView.setDotColor(R.color.yellow)
                rentalStatusView.setBackground(R.drawable.bg_yellow_round_7)
            }
        }

        rentalStatusView.setOnClickListener {
            PaymentDialog(context = it.context, year = 2021, month = month.dropLast(1).toInt(), "원빌딩 101호 서른커피"){ rentAmt, manageAmt ->
                rentalStatusView.setTextColor(R.color.sky_blue)
                rentalStatusView.setDotColor(R.color.sky_blue)
                rentalStatusView.setBackground(R.drawable.bg_sky_blue_round_7)
            }.show()
        }
    }

    override fun getItemViewType(position: Int): Int = currentList[position].type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == RentalStatusType.TYPE_TITLE){
            TitleViewHolder(CellRentalTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }else{
            DetailViewHolder(CellRentalStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is TitleViewHolder -> {
                if(currentList[position] is RentalStatusTitle){
                    holder.bind(currentList[position] as RentalStatusTitle)
                }
            }
            is DetailViewHolder -> {
                if(currentList[position] is RentalStatusDetail){
                    holder.bind(currentList[position] as RentalStatusDetail)
                }
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RentalStatusType>() {
            override fun areItemsTheSame(oldItem: RentalStatusType, newItem: RentalStatusType): Boolean = true

            override fun areContentsTheSame(oldItem: RentalStatusType, newItem: RentalStatusType): Boolean = true
        }
    }

}