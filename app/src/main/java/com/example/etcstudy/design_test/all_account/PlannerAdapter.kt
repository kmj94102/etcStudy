package com.example.etcstudy.design_test.all_account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellPlannerBinding

class PlannerAdapter : ListAdapter<PlannerItem, PlannerAdapter.PlannerViewHolder>(diffUtil) {

    inner class PlannerViewHolder(val binding : CellPlannerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(plannerItem : PlannerItem) = with(binding) {
            txtTitle.text = plannerItem.title
            txtDescription.text = plannerItem.description
//            viewBackground.setBackgroundColor(plannerItem.backgroundColorRes)
//            viewIcon.setBackgroundColor(plannerItem.iconColorRes)
            viewIcon.setBackgroundResource(plannerItem.iconRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlannerViewHolder =
        PlannerViewHolder(CellPlannerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PlannerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<PlannerItem>(){
            override fun areItemsTheSame(oldItem: PlannerItem, newItem: PlannerItem): Boolean = true

            override fun areContentsTheSame(oldItem: PlannerItem, newItem: PlannerItem): Boolean = true
        }
    }

}