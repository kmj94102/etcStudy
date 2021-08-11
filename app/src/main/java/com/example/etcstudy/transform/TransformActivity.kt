package com.example.etcstudy.transform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.size
import com.example.etcstudy.databinding.ActivityTransformBinding
import com.example.etcstudy.util.Constraint
import com.example.etcstudy.util.startActivity
import com.example.etcstudy.util.toast
import com.skydoves.transformationlayout.TransformationCompat

class TransformActivity : AppCompatActivity() {

    private val binding : ActivityTransformBinding by lazy { ActivityTransformBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        initRecyclerView()

    }


    private fun initViews(){
        binding.fab.setOnClickListener {
            binding.transformationLayout.startTransform()
        }

        binding.myCardView.setOnClickListener {
            binding.transformationLayout.finishTransform()
        }
    }


    private fun initRecyclerView(){
        val adapter = TestAdapter()

        binding.recyclerView.adapter = adapter

        adapter.submitList(getTestItemList())
    }


    private fun getTestItemList() : List<TestItem>{
        val list = mutableListOf<TestItem>()

        for (i in 0..30){
            list.add(TestItem(title = "title $i", content = "content $i"))
        }

        return list
    }


    override fun onBackPressed() {
        if(binding.transformationLayout.isTransformed){
            binding.transformationLayout.finishTransform()
            return
        }else{
            super.onBackPressed()
        }
    }

}