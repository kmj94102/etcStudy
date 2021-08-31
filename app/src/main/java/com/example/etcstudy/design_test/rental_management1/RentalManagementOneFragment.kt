package com.example.etcstudy.design_test.rental_management1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentRentalManagementOneBinding
import com.example.etcstudy.design_test.PaymentStatus
import com.example.etcstudy.design_test.Rental
import com.example.etcstudy.design_test.RentalStatusResult
import com.example.etcstudy.design_test.dialog.SelectLastMonthThreeMonthDialog
import com.example.etcstudy.design_test.tenant_detail.TenantDetailActivity
import com.example.etcstudy.transform.custom.CustomProgressbar
import com.example.etcstudy.transform.custom.ProgressItem
import com.example.etcstudy.util.startActivity
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

        layoutCalendar.setOnClickListener {
            SelectLastMonthThreeMonthDialog(requireContext(), 8){ startMonth, lastMonth ->
                binding.txtSelectMonth.text = "2021.${startMonth}.1 ~ 2021.${lastMonth}.31"
            }.show()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val newAdapter = RentalStatusAdapter()
                rvRentalStatus.adapter = newAdapter
                newAdapter.submitList(setAdapter())
            }

        })

        txtRentalStatus.setOnClickListener {
            requireActivity().startActivity<TenantDetailActivity>()
        }
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
        val tenantNameList = listOf("김철수", "이다니엘아", "3층 원빌딩 회의실", "1층 서른커피", "일이삼사오육칠팔구십일이삼사오", "김민재", "5층 지원과", "원랩 회의실", "임차인", "꼬륵 도시락", "하하",
            "테스트", "임차인", "안드로이드", "스튜디오", "제플린", "삼성", "LG", "APPLE", "기타", "사무실", "빌딩", "다이소")
        val monthList = listOf("1월/2월/3월", "4월/5월/6월", "7월/8월/9월", "10월/11월/12월", "2월/3월/4월", "5월/6월/7월", "8월/9월/10월")
        val selectMonthList = monthList.random().split("/")
        list.add(
            RentalStatusResult(
                ho = "101호",
                tenantName = tenantNameList.random(),
                startMonth = selectMonthList[0],
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = selectMonthList[1],
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = selectMonthList[2],
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "102호",
                tenantName = tenantNameList.random(),
                startMonth = selectMonthList[0],
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = selectMonthList[1],
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = selectMonthList[2],
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "201호",
                tenantName = tenantNameList.random(),
                startMonth = selectMonthList[0],
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = selectMonthList[1],
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = selectMonthList[2],
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "305호",
                tenantName = tenantNameList.random(),
                startMonth = selectMonthList[0],
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = selectMonthList[1],
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = selectMonthList[2],
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "306호",
                tenantName = tenantNameList.random(),
                startMonth = selectMonthList[0],
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = selectMonthList[1],
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = selectMonthList[2],
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        list.add(
            RentalStatusResult(
                ho = "306호",
                tenantName = tenantNameList.random(),
                startMonth = selectMonthList[0],
                startMonthStatus = Rental(PaymentStatus.values().random()),
                middleMonth = selectMonthList[1],
                middleMonthStatus = Rental(PaymentStatus.values().random()),
                endMonth = selectMonthList[2],
                endMonthStatus = Rental(PaymentStatus.values().random())
            )
        )

        return list
    }
}