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
        val tenantNameList = listOf("?????????", "???????????????", "3??? ????????? ?????????", "1??? ????????????", "?????????????????????????????????????????????", "?????????", "5??? ?????????", "?????? ?????????", "?????????", "?????? ?????????", "??????",
            "?????????", "?????????", "???????????????", "????????????", "?????????", "??????", "LG", "APPLE", "??????", "?????????", "??????", "?????????")
        val monthList = listOf("1???/2???/3???", "4???/5???/6???", "7???/8???/9???", "10???/11???/12???", "2???/3???/4???", "5???/6???/7???", "8???/9???/10???")
        val selectMonthList = monthList.random().split("/")
        list.add(
            RentalStatusResult(
                ho = "101???",
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
                ho = "102???",
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
                ho = "201???",
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
                ho = "305???",
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
                ho = "306???",
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
                ho = "306???",
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