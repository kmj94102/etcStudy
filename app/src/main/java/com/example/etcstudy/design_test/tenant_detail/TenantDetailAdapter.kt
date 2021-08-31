package com.example.etcstudy.design_test.tenant_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellTenantCardBinding

class TenantDetailAdapter(private val tenantList : MutableList<String>) : RecyclerView.Adapter<TenantDetailAdapter.TenantDetailViewHolder>() {

    inner class TenantDetailViewHolder(val binding : CellTenantCardBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(s: String) = with(binding){
            txtName.text = s
            viewMore.setOnClickListener {
                val animation = AlphaAnimation(0f, 1f).apply { duration = 1000 }
                layoutModify.isVisible = true
                layoutModify.animation = animation
            }
            btnCancel.setOnClickListener {
                val animation = AlphaAnimation(1f, 0f).apply { duration = 1000 }
                layoutModify.animation = animation
                layoutModify.isVisible = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenantDetailViewHolder =
        TenantDetailViewHolder(CellTenantCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: TenantDetailViewHolder, position: Int) {
        holder.bind(tenantList[position])
    }

    override fun getItemCount(): Int = tenantList.size

}