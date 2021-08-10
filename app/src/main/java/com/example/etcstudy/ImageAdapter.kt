package com.example.etcstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellImageBinding
import com.example.etcstudy.scoll_image.VerticalParallaxTransformer

class ImageAdapter : ListAdapter<ImageItem, ImageAdapter.ImageViewHolder>(diffUtil) {
    inner class ImageViewHolder(private val binding : CellImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imageItem: ImageItem){
            binding.imgScroll1.setBackgroundResource(imageItem.imageRes)
            binding.imgScroll2.setBackgroundResource(imageItem.imageRes)
            binding.imgScroll3.setBackgroundResource(imageItem.imageRes)
            binding.imgScroll2.visibility = View.GONE
            binding.imgScroll3.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(CellImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ImageItem>(){
            override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean = true

            override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean = true

        }
    }
}