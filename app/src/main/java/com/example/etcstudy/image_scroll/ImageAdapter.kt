package com.example.etcstudy.image_scroll

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.etcstudy.databinding.CellImageBinding
import com.example.etcstudy.util.transformStartActivity

class ImageAdapter : ListAdapter<ImageItem, ImageAdapter.ImageViewHolder>(diffUtil) {
    inner class ImageViewHolder(private val binding : CellImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imageItem: ImageItem){
            Glide.with(binding.imgScroll.context)
                .applyDefaultRequestOptions(RequestOptions.centerInsideTransform())
                .load(imageItem.backgroundImage)
                .into(binding.imgScroll)

            binding.root.setOnClickListener {
                it.context.transformStartActivity<ImageDetailActivity, ImageItem>(binding.transLayoutImage, imageItem)
            }
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