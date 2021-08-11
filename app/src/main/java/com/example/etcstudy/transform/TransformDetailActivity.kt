package com.example.etcstudy.transform

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityTransformDetailBinding
import com.example.etcstudy.util.Constraint
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout

class TransformDetailActivity : AppCompatActivity() {

    private val binding : ActivityTransformDetailBinding by lazy { ActivityTransformDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getParcelableExtra<TestItem>(Constraint.INTENT_TEST_ITEM)?.let {
            binding.txtMessage.text = it.title.plus("\n${it.content}\n선택되었습니다.")
        }

    }

    companion object {
        fun startActivity(context: Context, transformationLayout: TransformationLayout, testItem: TestItem){
            val intent = Intent(context, TransformDetailActivity::class.java)
            intent.putExtra(Constraint.INTENT_TEST_ITEM, testItem)
            TransformationCompat.startActivity(transformationLayout, intent)
        }
    }
}