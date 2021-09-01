package com.example.etcstudy.design_test.tenant_detail

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityTenantDetailBinding
import com.example.etcstudy.design_test.all_account.AnimationAdapter
import com.example.etcstudy.design_test.custom.SelectMonthView
import com.example.etcstudy.util.getCurrentDateTime
import com.example.etcstudy.util.toString

class TenantDetailActivity : AppCompatActivity() {

    private val binding : ActivityTenantDetailBinding by lazy { ActivityTenantDetailBinding.inflate(layoutInflater) }
    private lateinit var adapter: AnimationAdapter
    private val monthList = mutableListOf<SelectMonthView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() = with(binding){
        monthList.addAll(
            listOf(viewJanuary, viewFebruary, viewMarch, viewApril, viewMay, viewJune, viewJuly, viewAugust, viewSeptember, viewOctober, viewNovember, viewDecember)
        )

        adapter = AnimationAdapter { month, isComplete ->
            val selectMonth = monthList.find { it.tag.toString().padStart(2, '0') == month }
            selectMonth?.setDotColor(if(isComplete) R.color.sky_blue else R.color.red)
        }

        viewPager.adapter = adapter

        adapter.submitList(setAdapter())
        viewPagerSetting()

    }

    private fun viewPagerSetting() = with(binding){
        viewPager.offscreenPageLimit = 3
        viewPager.orientation = ORIENTATION_HORIZONTAL
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.margin_sixteen)
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.margin_eleven)
        viewPager.setPageTransformer{ page, position ->
            val myOffset = position * - (2 * pageOffset + pageMargin)
            if(viewPager.orientation == ORIENTATION_HORIZONTAL){
                if(ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL){
                    page.translationX = -myOffset
                }else{
                    page.translationX = myOffset
                }
            }else{
                page.translationY = myOffset
            }
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Handler(mainLooper).postDelayed({

                    val currentTenantDetail = adapter.getCurrentItem(position)

                    if (currentTenantDetail == null){
                        txtTitle.text = "임차인 추가"
                    }else{
                        txtTitle.text = currentTenantDetail.buildingName
                    }
                    setCalendar(currentTenantDetail)

                }, 100)
            }
        })
    }

    private fun setAdapter() : List<TenantDetail>{
        val list = mutableListOf<TenantDetail>()
        list.add(
            TenantDetail(
                tenantName = "홍길동",
                buildingName = "원랩빌딩(1/3)",
                area = "108㎡",
                contractPeriod = "2020.01.02 ~ 2023.01.02 (D-35)",
                yield = "5.2%",
                deposit = "보증금 2500만원",
                currentMonth = "09",
                monthly = "4,852,000",
                nonPayment = "- 1,852,000",
                nonPayMonths = "07, 08, 09",
                isDepositCompleted = false
            )
        )

        list.add(
            TenantDetail(
                tenantName = "김민재",
                buildingName = "원랩빌딩(2/3)",
                area = "200㎡",
                contractPeriod = "2020.01.02 ~ 2024.01.02 (D-350)",
                yield = "8.2%",
                deposit = "보증금 3500만원",
                currentMonth = "09",
                monthly = "1,000,000",
                nonPayment = "0",
                nonPayMonths = "",
                isDepositCompleted = true
            )
        )

        list.add(
            TenantDetail(
                tenantName = "회의실",
                buildingName = "원랩빌딩(3/3)",
                area = "88㎡",
                contractPeriod = "2020.09.09 ~ 2021.07.23 (D-1555)",
                yield = "5.2%",
                deposit = "보증금 5500만원",
                currentMonth = "09",
                monthly = "550,000",
                nonPayment = "- 85,850,000",
                nonPayMonths = "01, 09",
                isDepositCompleted = false
            )
        )

        return list
    }

    private fun setCalendar(tenantDetail : TenantDetail?) = with(binding) {
        val date = getCurrentDateTime()
        val month = date.toString("MM")

        txtYear.text = date.toString("yyyy").plus("년")

        if(tenantDetail != null){
            val nonPayMonthList = tenantDetail.nonPayMonths?.split(", ")

            monthList.forEach { selectMonth ->
                if (selectMonth.tag.toString() <= month){
                    selectMonth.setDotColor(if((nonPayMonthList?.find { it == selectMonth.tag }) == null) R.color.sky_blue else R.color.red)
                    selectMonth.setBackground(if (selectMonth.tag.toString() == month) R.drawable.bg_circle_round else android.R.color.transparent)
                    selectMonth.setTextColor(R.color.black)
                }else{
                    selectMonth.setDotColor(android.R.color.transparent)
                    selectMonth.setTextColor(R.color.text_color_secondary_27)
                }
            }
        }else{
            monthList.forEach { selectMonth ->
                selectMonth.setDotColor(android.R.color.transparent)
                selectMonth.setBackground(if (selectMonth.tag.toString() == month) R.drawable.bg_circle_round else android.R.color.transparent)
                selectMonth.setTextColor(R.color.text_color_secondary_27)
            }
        }
    }

}