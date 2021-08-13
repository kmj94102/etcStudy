package com.example.etcstudy.design_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityRentalBookBinding
import com.example.etcstudy.transform.custom.CustomProgressbar
import com.example.etcstudy.transform.custom.ProgressItem

class RentalBookActivity : AppCompatActivity() {

    private val binding : ActivityRentalBookBinding by lazy { ActivityRentalBookBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }


    private fun initViews() = with(binding){
        initProgressRentalStatus(progressRentalStatus)
    }

    private fun initProgressRentalStatus(progressRentalStatus: CustomProgressbar) {
        progressRentalStatus.thumb.mutate().alpha = 0

        var mProgressItem = ProgressItem(progressItemPercentage = 100f, color = R.color.yellow)
        val progressItemList = arrayListOf<ProgressItem>()
        progressItemList.add(mProgressItem)

        mProgressItem = ProgressItem(progressItemPercentage = 80f, color = R.color.red)
        progressItemList.add(mProgressItem)

        mProgressItem = ProgressItem(progressItemPercentage = 40f, color = R.color.sky_blue)
        progressItemList.add(mProgressItem)

        progressRentalStatus.initData(progressItemList)
        progressRentalStatus.invalidate()
    }

}