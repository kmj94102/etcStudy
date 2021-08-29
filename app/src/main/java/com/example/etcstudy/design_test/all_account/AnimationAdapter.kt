package com.example.etcstudy.design_test.all_account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellMotionBinding
import com.example.etcstudy.design_test.RentalStatusResult

class AnimationAdapter : ListAdapter<RentalStatusResult, AnimationAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(binding : CellMotionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CellMotionBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RentalStatusResult>(){
            override fun areItemsTheSame(
                oldItem: RentalStatusResult,
                newItem: RentalStatusResult
            ): Boolean  = oldItem.tenantName == newItem.tenantName

            override fun areContentsTheSame(
                oldItem: RentalStatusResult,
                newItem: RentalStatusResult
            ): Boolean = oldItem == newItem
        }
    }

}