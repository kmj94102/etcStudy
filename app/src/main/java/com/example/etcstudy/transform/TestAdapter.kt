package com.example.etcstudy.transform

import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellTestBinding

class TestAdapter : ListAdapter<TestItem, TestAdapter.ViewHolder>(diffUtil) {

    private var previousTime = SystemClock.elapsedRealtime()

    inner class ViewHolder(private val binding : CellTestBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(testItem: TestItem){
            binding.txtTitle.text = testItem.title
            binding.txtContent.text = testItem.content

            binding.root.setOnClickListener {
                val now = SystemClock.elapsedRealtime()
                if (now - previousTime >= binding.transLayoutTestItem.duration) {
                    TransformDetailActivity.startActivity(binding.root.context, binding.transLayoutTestItem, testItem)
                    previousTime = now
                    Log.e("+++++", "if true")
                }else{
                    Log.e("+++++", "if false")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CellTestBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TestItem>(){
            override fun areItemsTheSame(oldItem: TestItem, newItem: TestItem): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: TestItem, newItem: TestItem): Boolean = oldItem.title == newItem.title
        }
    }

}