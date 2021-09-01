package com.example.etcstudy.design_test.all_account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CellAddTenantBinding
import com.example.etcstudy.databinding.CellMotionBinding
import com.example.etcstudy.design_test.tenant_detail.TenantDetail

class AnimationAdapter(val onCompletionListener: (String?, Boolean) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val currentList = mutableListOf<TenantDetail>()

    inner class DetailViewHolder(val binding : CellMotionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(tenantDetail: TenantDetail) = with(binding) {
            imgMore.setOnClickListener {
                motionLayout.transitionToEnd()
            }
            imgClose.setOnClickListener {
                motionLayout.transitionToStart()
            }

            txtYield.text = tenantDetail.yield
            txtTenantName.text = tenantDetail.tenantName
            txtArea.text = tenantDetail.area
            txtContractPeriod.text = tenantDetail.contractPeriod
            txtDeposit.text = tenantDetail.deposit
            txtMonthly.text = tenantDetail.monthly
            txtNonPayment.text = tenantDetail.nonPayment
            viewDepositCompleted.setBackgroundResource(if (tenantDetail.isDepositCompleted == true) R.drawable.bg_sky_blue_bottom_round_16 else R.drawable.bg_gray_bottom_round_16)

            if (tenantDetail.nonPayment == "0"){
                txtNonPayment.setTextColor(txtNonPayment.context.getColor(R.color.text_color_secondary_38))
            }

            viewDepositCompleted.setOnClickListener {
                when(tenantDetail.isDepositCompleted){
                    true->{
                        tenantDetail.nonPayment = "-${tenantDetail.monthly}"
                        tenantDetail.isDepositCompleted = false
                        tenantDetail.nonPayMonths += ", ${tenantDetail.currentMonth}"

                        viewDepositCompleted.setBackgroundResource(R.drawable.bg_gray_bottom_round_16)
                        txtNonPayment.text = tenantDetail.nonPayment
                        txtNonPayment.setTextColor(txtNonPayment.context.getColor(R.color.red))

                        onCompletionListener(tenantDetail.currentMonth, false)
                    }
                    false->{
                        tenantDetail.nonPayment = "0"
                        tenantDetail.isDepositCompleted = true
                        tenantDetail.nonPayMonths = tenantDetail.nonPayMonths?.replace(tenantDetail.currentMonth ?: "99", "")

                        viewDepositCompleted.setBackgroundResource(R.drawable.bg_sky_blue_bottom_round_16)
                        txtNonPayment.text = tenantDetail.nonPayment
                        txtNonPayment.setTextColor(txtNonPayment.context.getColor(R.color.text_color_secondary_38))

                        onCompletionListener(tenantDetail.currentMonth, true)
                    }
                }
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

    fun getCurrentItem(position: Int) = if(position < currentList.size) currentList[position] else null

    companion object {
        const val DETAILS = 0
        const val ADD = 1
    }

}