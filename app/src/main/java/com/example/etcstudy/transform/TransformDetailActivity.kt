package com.example.etcstudy.transform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.etcstudy.databinding.ActivityTransformDetailBinding
import com.example.etcstudy.util.Constraint
import com.skydoves.transformationlayout.onTransformationEndContainer

class TransformDetailActivity : AppCompatActivity() {

    private val binding : ActivityTransformDetailBinding by lazy { ActivityTransformDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainer(intent.getParcelableExtra(Constraint.INTENT_TRANSFORM_END))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getParcelableExtra<TestItem>(Constraint.INTENT_TRANSFORM_PARAM)?.let {
            binding.txtMessage.text = it.title.plus("\n${it.content}\n선택되었습니다.")
        }

    }
}