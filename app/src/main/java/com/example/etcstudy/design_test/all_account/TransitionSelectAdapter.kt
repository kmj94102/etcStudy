package com.example.etcstudy.design_test.all_account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellTransitionSelectItemBinding

class TransitionSelectAdapter(val itemClickListener : () -> Unit) : ListAdapter<String, TransitionSelectAdapter.TransitionViewHolder>(diffUtil) {

    inner class TransitionViewHolder(val binding : CellTransitionSelectItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                itemClickListener()
            }
        }

        fun bind(item: String) {
            binding.txtItem.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransitionViewHolder =
        TransitionViewHolder(CellTransitionSelectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: TransitionViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        }
    }

}