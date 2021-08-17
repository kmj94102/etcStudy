package com.example.etcstudy.design_test.rental_management1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentRentalManagementOneBinding
import com.example.etcstudy.design_test.PaymentStatus
import com.example.etcstudy.design_test.Rental
import com.example.etcstudy.design_test.RentalStatusAdapter
import com.example.etcstudy.design_test.RentalStatusResult
import com.example.etcstudy.transform.custom.CustomProgressbar
import com.example.etcstudy.transform.custom.ProgressItem
import com.google.android.material.tabs.TabLayout

class RentalManagementOneFragment : Fragment() {

    private val binding : FragmentRentalManagementOneBinding by lazy { FragmentRentalManagementOneBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                tenantName = "이다니엘아",
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
                tenantName = "3층 원빌딩 회의실",
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
                tenantName = "1층 서른커피",
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
                ho = "306호",
                tenantName = "일이삼사오육칠팔구십일이삼사오",
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
                ho = "306호",
                tenantName = "일이삼사오육칠팔구십일이삼사오일이삼사오육칠팔구십일이삼사오일이삼사오육칠팔구십일이삼사오일이삼사오육칠팔구십일이삼사오",
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
}