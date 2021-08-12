package com.example.etcstudy.image_scroll

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.etcstudy.databinding.ActivityImageDetailBinding
import com.example.etcstudy.util.Constraint
import com.skydoves.transformationlayout.onTransformationEndContainer

class ImageDetailActivity : AppCompatActivity() {

    private val binding : ActivityImageDetailBinding by lazy { ActivityImageDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainer(intent.getParcelableExtra(Constraint.INTENT_TRANSFORM_END))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getParcelableExtra<ImageItem>(Constraint.INTENT_TRANSFORM_PARAM)?.let { imageItem ->
            binding.layoutBackground.setBackgroundColor(Color.parseColor(imageItem.backgroundColor))

            Glide.with(this)
                .load(imageItem.backgroundImage)
                .into(binding.imgBackground)

            Glide.with(this)
                .load(imageItem.characterImage)
                .into(binding.imgCharacter)

            setGradient(imageItem.backgroundColor)
        }

    }


    private fun setGradient(color : String){
        val startColor = Color.TRANSPARENT
        val endColor = Color.parseColor(color)
        val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(startColor, endColor, endColor, endColor, endColor, endColor, endColor, endColor, endColor))
        binding.imgBottomBackground.background = gradientDrawable
    }
}