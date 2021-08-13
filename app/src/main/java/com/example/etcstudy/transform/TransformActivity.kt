package com.example.etcstudy.transform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.size
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityTransformBinding
import com.example.etcstudy.transform.custom.ProgressItem
import com.example.etcstudy.util.Constraint
import com.example.etcstudy.util.startActivity
import com.example.etcstudy.util.toast
import com.skydoves.transformationlayout.TransformationCompat

class TransformActivity : AppCompatActivity() {

    private val binding : ActivityTransformBinding by lazy { ActivityTransformBinding.inflate(layoutInflater) }
    private val progressItemList : ArrayList<ProgressItem> = arrayListOf()
    private lateinit var mProgressItem : ProgressItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        initRecyclerView()

        initSeekBar()

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


    private fun initSeekBar(){
        binding.seekBar.thumb.mutate().alpha = 0
        mProgressItem = ProgressItem(progressItemPercentage = 100f, color = android.R.color.holo_red_dark)
        progressItemList.add(mProgressItem)

        mProgressItem = ProgressItem(progressItemPercentage = 80f, color = android.R.color.holo_blue_light)
        progressItemList.add(mProgressItem)

        mProgressItem = ProgressItem(progressItemPercentage = 40f, color = android.R.color.holo_green_dark)
        progressItemList.add(mProgressItem)

        binding.seekBar.initData(progressItemList)
        binding.seekBar.invalidate()
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