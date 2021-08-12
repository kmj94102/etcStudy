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
            list.add(
                ImageItem(
                    backgroundImage = "https://kr-a.kakaopagecdn.com/P/C/792/bg/2x/7e9cde2b-352e-4d34-84f4-df37caea2421.jpg",
                    characterImage = "https://kr-a.kakaopagecdn.com/P/C/792/c1/2x/7e9cde2b-352e-4d34-84f4-df37caea2421.png",
                    backgroundColor = "#FF000000",
                    title = "블랙 베히모스"
                )
            )

            list.add(
                ImageItem(
                    backgroundImage = "https://kr-a.kakaopagecdn.com/P/C/1796/bg/2x/0101e0c9-6ff1-43f7-a5a2-949addd38fac.jpg",
                    characterImage = "https://kr-a.kakaopagecdn.com/P/C/1796/c1/2x/0101e0c9-6ff1-43f7-a5a2-949addd38fac.png",
                    backgroundColor = "#FF4B322D",
                    title = "샬롯에게는 다섯 명의 제자가 있다"
                )
            )

            list.add(
                ImageItem(
                    backgroundImage = "https://kr-a.kakaopagecdn.com/P/C/2145/bg/2x/70b098f5-3bbc-4855-8ed7-e96d74b9313c.jpg",
                    characterImage = "https://kr-a.kakaopagecdn.com/P/C/2145/c1/2x/70b098f5-3bbc-4855-8ed7-e96d74b9313c.png",
                    backgroundColor = "#FF816E6A",
                    title = "사랑하면 디져~트"
                )
            )

        }

        adapter.submitList(list)

    }
}