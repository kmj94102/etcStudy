package com.example.etcstudy.design_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityRentalBookBinding
import com.example.etcstudy.design_test.rental_management1.RentalStatusAdapter
import com.example.etcstudy.transform.custom.CustomProgressbar
import com.example.etcstudy.transform.custom.ProgressItem
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.tabs.TabLayout

class RentalBookActivity : AppCompatActivity() {

    private val binding : ActivityRentalBookBinding by lazy { ActivityRentalBookBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }


    private fun initViews() = with(binding){
        initProgressRentalStatus(progressRentalStatus)

        val adapter = RentalStatusAdapter()
        rvRentalStatus.adapter = adapter

        adapter.submitList(setAdapter())


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val newAdapter = RentalStatusAdapter()
                rvRentalStatus.adapter = newAdapter
                newAdapter.submitList(setAdapter())
            }

        })

        setChart(binding.chart)

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

    private fun setAdapter() : List<RentalStatusResult>{
        val list = mutableListOf<RentalStatusResult>()
        PaymentStatus.values().random()
        list.add(
            RentalStatusResult(
                ho = "101호",
                tenantName = "김철수",
                startMonth = "6월",
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = "7월",
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = "8월",
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "102호",
                tenantName = "김철수",
                startMonth = "6월",
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = "7월",
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = "8월",
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "201호",
                tenantName = "김철수",
                startMonth = "6월",
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = "7월",
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = "8월",
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "305호",
                tenantName = "김철수",
                startMonth = "6월",
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = "7월",
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = "8월",
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        return list
    }

    private fun setChart(chart: PieChart) {
        chart.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(7f, ""))
        entries.add(PieEntry(2f, ""))
        entries.add(PieEntry(3f, ""))

        val colorsItems = arrayListOf(
            ContextCompat.getColor(this, R.color.sky_blue),
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.yellow)
        )

        val pieDataSet = PieDataSet(entries, "").apply {
            colors = colorsItems
            valueTextSize = 0f
        }

        val pieData = PieData(pieDataSet)
        chart.apply {
            data = pieData
            // 차트 설명
            description.isEnabled = false
            // 원형 차트 범위 : 0f ~ 360f
            maxAngle = 180f
            // 차트 회전
            rotationAngle = 180f
            // 차트 범례 표시여부
            legend.isEnabled = false
            // 터치 가능 여부
            setTouchEnabled(false)
            isDrawHoleEnabled = true
            setTransparentCircleAlpha(0)
            setBackgroundResource(R.color.light_gray)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

    }

}