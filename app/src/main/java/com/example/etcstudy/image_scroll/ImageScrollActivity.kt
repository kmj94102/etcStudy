package com.example.etcstudy.image_scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityImageScrollBinding

class ImageScrollActivity : AppCompatActivity() {

    private val binding : ActivityImageScrollBinding by lazy { ActivityImageScrollBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = ImageAdapter()
        val list = mutableListOf<ImageItem>()
        binding.recyclerView.adapter = adapter

        for(i in 0..20){
            list.add(ImageItem(imageRes = R.drawable.bg_img))
        }

        adapter.submitList(list)

    }
}