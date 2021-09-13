package com.example.etcstudy

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityMainBinding
import com.example.etcstudy.design_test.DesignActivity
import com.example.etcstudy.tree_structure.TreeActivity
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

            btnDesign1.setOnClickListener {
                startActivity<DesignActivity>()
                finish()
            }

            btnTree.setOnClickListener {
                startActivity<TreeActivity>()
                finish()
            }

            btnObjectAnimator.setOnClickListener {
                startActivity<ObjectAnimatorActivity>()
                finish()
            }

//            btnDesign1.performClick()
        }

    }
}