package com.example.etcstudy.design_test.all_account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityPlannerDetailBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class PlannerDetailActivity : AppCompatActivity() {

    private val binding : ActivityPlannerDetailBinding by lazy { ActivityPlannerDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        settingViewPager()

        settingAnyChart()

    }

    private fun settingViewPager(){
        val adapter = WalletAdapter()
        binding.viewPager.apply {
            this.adapter = adapter
            //        binding.viewPager.setPageTransformer(StackPageTransformer(3, StackPageTransformer.Orientation.VERTICAL, 0.95f, 0.6f, 0.5f, StackPageTransformer.Gravity.TOP))
            setPageTransformer(ViewPagerStack())
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        adapter.submitList(getList())
    }

    private fun getList() : List<WalletItem> {
        val list = mutableListOf<WalletItem>()

        list.addAll(
            listOf(
                WalletItem(
                    title = "1",
                    price = "",
                    cardColorRes = R.color.red
                ),
                WalletItem(
                    title = "2",
                    price = "",
                    cardColorRes = R.color.yellow
                ),
                WalletItem(
                    title = "3",
                    price = "",
                    cardColorRes = R.color.sky_blue
                ),
                WalletItem(
                    title = "4",
                    price = "",
                    cardColorRes = R.color.gray_chart
                ),
                WalletItem(
                    title = "5",
                    price = "",
                    cardColorRes = R.color.dark_yellow
                ),WalletItem(
                    title = "6",
                    price = "",
                    cardColorRes = R.color.orange
                )
            )
        )

        return list
    }

    private fun settingAnyChart(){

        binding.chart.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(1f, ""))
        entries.add(PieEntry(1f, ""))
        entries.add(PieEntry(1f, ""))
        entries.add(PieEntry(1f, ""))
        entries.add(PieEntry(1f, ""))

        val colorsItems = arrayListOf(
            ContextCompat.getColor(this, R.color.sky_blue),
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.yellow),
            ContextCompat.getColor(this, R.color.purple_200),
            ContextCompat.getColor(this, R.color.light_gray)
        )

        val pieDataSet = PieDataSet(entries, "").apply {
            colors = colorsItems
            valueTextSize = 0f
            sliceSpace = 2f
            selectionShift = 14f
        }

        val pieData = PieData(pieDataSet)
        binding.chart.apply {
            data = pieData
            // 차트 설명 표시 여부
            description.isEnabled = false
            // 차트 회전 여부
            isRotationEnabled = false
            // 차트 범례 표시여부
            legend.isEnabled = false
            // 차트 영역 라운드 범위 및 색상
            transparentCircleRadius = 0f
            isClickable = false
            // 터치 가능 여부
            setTouchEnabled(false)
            setTransparentCircleColor(android.R.color.transparent)
            isDrawHoleEnabled = true
            setHoleColor(android.R.color.transparent)
            holeRadius = 70f
            rotation = 340f
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

    }

}