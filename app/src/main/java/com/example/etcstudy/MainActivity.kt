package com.example.etcstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityMainBinding
import com.example.etcstudy.image_scroll.ImageScrollActivity
import com.example.etcstudy.transform.TransformActivity
import com.example.etcstudy.util.startActivity

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            btnImageScroll.setOnClickListener {
                startActivity<ImageScrollActivity>()
                finish()
            }

            btnTransformation.setOnClickListener {
                startActivity<TransformActivity>()
                finish()
            }
        }

    }
}