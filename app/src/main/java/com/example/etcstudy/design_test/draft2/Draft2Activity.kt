package com.example.etcstudy.design_test.draft2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityDraft2Binding
import com.example.etcstudy.design_test.custom.MonthlyCalendarView

class Draft2Activity : AppCompatActivity() {

    private val binding : ActivityDraft2Binding by lazy { ActivityDraft2Binding.inflate(layoutInflater) }
    private lateinit var adapter : Draft2Adapter
    private var calendarList = mutableListOf<MonthlyCalendarView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() = with(binding) {
        setViewPager(viewPager)
        calendarList.addAll(
            listOf(viewCalendarJanuary, viewCalendarFebruary, viewCalendarMarch, viewCalendarApril, viewCalendarMay, viewCalendarJune,
            viewCalendarJuly, viewCalendarAugust, viewCalendarSeptember, viewCalendarOctober, viewCalendarNovember, viewCalendarDecember)
        )

        viewBack.setOnClickListener { finish() }
    }

    private fun setViewPager(viewPager: ViewPager2) {
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.margin_eight)
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.margin_eleven)

        adapter = Draft2Adapter {
            calendarList[8].setComplete(true)
        }

        viewPager.apply {
            adapter = this@Draft2Activity.adapter
            offscreenPageLimit = 3
            orientation = ViewPager2.ORIENTATION_HORIZONTAL

            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            setPageTransformer{ page, position ->
                val myOffset = position * - (2 * pageOffset + pageMargin)
                if(viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL){
                    if(ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL){
                        page.translationX = -myOffset
                    }else{
                        page.translationX = myOffset
                    }
                }else{
                    page.translationY = myOffset
                }
            }

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    Handler(mainLooper).postDelayed({
                        val item = this@Draft2Activity.adapter.getCurrentItem(position)
                        setMonthlyCalendarView(item.monthlyStatusList)
                    }, 100)

                }
            })
        }.also {
            binding.viewIndicator.setViewPager2(viewPager)
        }

        adapter.submitList(getTenantList())
    }

    private fun getTenantList() = listOf(
        DraftItem(
            buildingName = "비오피스텔",
            area = "82㎡",
            contractPeriod = "2021.01.02 ~ 2023.01.02",
            yield = "3.25%",
            tenantName = "홍길동",
            ho = "1504호",
            deposit = "2500만원",
            monthly = "120만원",
            monthlyAmount = "1852000",
            monthlyStatusList = listOf(
                MonthlyStatus(month = "01", isEnable = true, isComplete = true),
                MonthlyStatus(month = "02", isEnable = true, isComplete = true),
                MonthlyStatus(month = "03", isEnable = true, isComplete = true),
                MonthlyStatus(month = "04", isEnable = true, isComplete = true),
                MonthlyStatus(month = "05", isEnable = true, isComplete = true),
                MonthlyStatus(month = "06", isEnable = true, isComplete = true),
                MonthlyStatus(month = "07", isEnable = true, isComplete = true),
                MonthlyStatus(month = "08", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "09", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "10", isEnable = false, isComplete = true),
                MonthlyStatus(month = "11", isEnable = false, isComplete = true),
                MonthlyStatus(month = "12", isEnable = false, isComplete = true)
            )
        ),
        DraftItem(
            buildingName = "씨오피스텔",
            area = "802㎡",
            contractPeriod = "2021.01.02 ~ 2023.01.02",
            yield = "3.25%",
            tenantName = "홍길동",
            ho = "1504호",
            deposit = "2500만원",
            monthly = "120만원",
            monthlyAmount = "1852000",
            monthlyStatusList = listOf(
                MonthlyStatus(month = "01", isEnable = true, isComplete = true),
                MonthlyStatus(month = "02", isEnable = true, isComplete = true),
                MonthlyStatus(month = "03", isEnable = true, isComplete = true),
                MonthlyStatus(month = "04", isEnable = true, isComplete = true),
                MonthlyStatus(month = "05", isEnable = true, isComplete = true),
                MonthlyStatus(month = "06", isEnable = true, isComplete = true),
                MonthlyStatus(month = "07", isEnable = true, isComplete = true),
                MonthlyStatus(month = "08", isEnable = true, isComplete = true),
                MonthlyStatus(month = "09", isEnable = true, isComplete = true),
                MonthlyStatus(month = "10", isEnable = false, isComplete = true),
                MonthlyStatus(month = "11", isEnable = false, isComplete = true),
                MonthlyStatus(month = "12", isEnable = false, isComplete = true)
            )
        ),
        DraftItem(
            buildingName = "디오피스텔",
            area = "82㎡",
            contractPeriod = "2021.01.02 ~ 2023.01.02",
            yield = "3.25%",
            tenantName = "홍길동",
            ho = "1504호",
            deposit = "2500만원",
            monthly = "120만원",
            monthlyAmount = "1852000",
            monthlyStatusList = listOf(
                MonthlyStatus(month = "01", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "02", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "03", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "04", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "05", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "06", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "07", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "08", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "09", isEnable = true, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "10", isEnable = false, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "11", isEnable = false, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원"),
                MonthlyStatus(month = "12", isEnable = false, isComplete = false, receivedAmount = "20만원", remainingAmount = "100만원")
            )
        )
    )

    private fun setMonthlyCalendarView(monthlyStatusList : List<MonthlyStatus>){
        monthlyStatusList.forEachIndexed { index, monthlyStatus ->
            calendarList[index].apply {
                val isContentsVisible = monthlyStatus.receivedAmount != null && monthlyStatus.remainingAmount != null
                setMonth(monthlyStatus.month)
                setComplete(monthlyStatus.isComplete)
                setContents(isContentsVisible = isContentsVisible, receivedAmount = monthlyStatus.receivedAmount, remainingAmount = monthlyStatus.remainingAmount)
                setEnable(monthlyStatus.isEnable)
            }
        }
    }
}