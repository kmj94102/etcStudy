package com.example.etcstudy.design_test.draft2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellDraftItemBinding
import com.example.etcstudy.design_test.custom.NumberTextWatcher
import com.example.etcstudy.util.toAmountComma

class Draft2Adapter(private val paymentListener : () -> Unit) : RecyclerView.Adapter<Draft2Adapter.ViewHolder>() {

    val list = mutableListOf<DraftItem>()

    inner class ViewHolder(val binding : CellDraftItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: DraftItem) = with(binding) {
            txtBuildingName.text = item.buildingName
            txtArea.text = item.area
            txtContractPeriod.text = item.contractPeriod
            txtYield.text = item.yield
            txtTenantName.text = item.tenantName
            txtHo.text = item.ho
            txtDepositMonthly.text = item.deposit.plus(" / ").plus(item.monthly)
            editMonthlyAmount.setText(item.monthlyAmount?.toLong()?.toAmountComma())

            editMonthlyAmount.addTextChangedListener(NumberTextWatcher(editMonthlyAmount))

            btnPayment.setOnClickListener {
                editMonthlyAmount.setText("1200000")
                paymentListener()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CellDraftItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun submitList(list : List<DraftItem>) = this.list.addAll(list)

    fun getCurrentItem(position: Int) = list[position]

}