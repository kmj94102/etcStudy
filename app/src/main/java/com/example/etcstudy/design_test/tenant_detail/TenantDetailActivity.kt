package com.example.etcstudy.design_test.tenant_detail

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityTenantDetailBinding
import com.example.etcstudy.design_test.PaymentStatus
import com.example.etcstudy.design_test.Rental
import com.example.etcstudy.design_test.RentalStatusResult
import com.example.etcstudy.design_test.all_account.AnimationAdapter
import kotlin.math.abs

class TenantDetailActivity : AppCompatActivity() {

    private val binding : ActivityTenantDetailBinding by lazy { ActivityTenantDetailBinding.inflate(layoutInflater) }
    lateinit var adapter: AnimationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() = with(binding){
        adapter = AnimationAdapter()

        viewPager.adapter = adapter

        adapter.submitList(setAdapter())

        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer((11/ Resources.getSystem().displayMetrics.density).toInt()))
//        transformer.addTransformer { page, position ->
//            val v = 1 - abs(position)
//            page.scaleY = 0.8f + v * 00.2f
//        }
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.orientation = ORIENTATION_HORIZONTAL
//        binding.viewPager.setPageTransformer(transformer)
//        binding.viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.margin_sixteen)
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.margin_eleven)
        binding.viewPager.setPageTransformer{ page, position ->
            val myOffset = position * - (2 * pageOffset + pageMargin)
            if(binding.viewPager.orientation == ORIENTATION_HORIZONTAL){
                if(ViewCompat.getLayoutDirection(binding.viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL){
                    page.translationX = -myOffset
                }else{
                    page.translationX = myOffset
                }
            }else{
                page.translationY = myOffset
            }
        }
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
                monthly = "4,852,000",
                nonPayment = "- 1,852,000",
                nonPayMonths = "7, 8",
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
                monthly = "1,000,000",
                nonPayment = "0",
                nonPayMonths = "7",
                isDepositCompleted = true
            )
        )

        list.add(
            TenantDetail(
                tenantName = "회의실",
                buildingName = "원랩빌딩(3/3)",
                area = "108㎡",
                contractPeriod = "2020.01.02 ~ 2023.01.02 (D-35)",
                yield = "5.2%",
                deposit = "보증금 2500만원",
                monthly = "4,852,000",
                nonPayment = "- 1,852,000",
                nonPayMonths = "7",
                isDepositCompleted = false
            )
        )

        return list
    }

}