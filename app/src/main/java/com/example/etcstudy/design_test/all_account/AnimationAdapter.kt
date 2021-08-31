package com.example.etcstudy.design_test.all_account

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CellAddTenantBinding
import com.example.etcstudy.databinding.CellMotionBinding
import com.example.etcstudy.design_test.tenant_detail.TenantDetail

class AnimationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val currentList = mutableListOf<TenantDetail>()

    inner class DetailViewHolder(val binding : CellMotionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(tenantDetail: TenantDetail) {
            binding.imgMore.setOnClickListener {
                Log.e("+++++", "imgMore click")
                binding.motionLayout.transitionToEnd()
            }
            binding.imgClose.setOnClickListener {
                Log.e("+++++", "imgClose click")
                binding.motionLayout.transitionToStart()
            }

            binding.txtYield.text = tenantDetail.yield
            binding.txtTenantName.text = tenantDetail.tenantName
            binding.txtArea.text = tenantDetail.area
            binding.txtContractPeriod.text = tenantDetail.contractPeriod
            binding.txtDeposit.text = tenantDetail.deposit
            binding.txtMonthly.text = tenantDetail.monthly
            binding.txtNonPayment.text = tenantDetail.nonPayment
            binding.viewDepositCompleted.setBackgroundResource(if (tenantDetail.isDepositCompleted == true) R.drawable.bg_sky_blue_bottom_round_16 else R.drawable.bg_gray_bottom_round_16)

            if (tenantDetail.nonPayment == "0"){
                binding.txtNonPayment.isVisible = false
                binding.txtWon.isVisible = false
            }

            binding.viewDepositCompleted.setOnClickListener {
                if(tenantDetail.isDepositCompleted == true) return@setOnClickListener

                binding.viewDepositCompleted.setBackgroundResource(R.drawable.bg_sky_blue_bottom_round_16)
            }
        }
    }

    inner class AddViewHolder(val binding : CellAddTenantBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (position < currentList.size) DETAILS else ADD
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == DETAILS) DetailViewHolder(CellMotionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        else AddViewHolder(CellAddTenantBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is DetailViewHolder){
            holder.bind(currentList[position])
        }
    }

    fun submitList(addList : List<TenantDetail>){
        currentList.addAll(addList)
    }

    fun getCurrentItem(position: Int) = currentList[position]

    companion object {
        const val DETAILS = 0
        const val ADD = 1
    }

}