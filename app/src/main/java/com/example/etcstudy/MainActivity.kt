package com.example.etcstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

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