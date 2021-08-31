package com.example.etcstudy.design_test.all_account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.CellMotionBinding
import com.example.etcstudy.databinding.FragmentAllAccountBinding
import com.example.etcstudy.design_test.PaymentStatus
import com.example.etcstudy.design_test.Rental
import com.example.etcstudy.design_test.RentalStatusResult
import com.example.etcstudy.design_test.tenant_detail.TenantDetail

class AllAccountFragment : Fragment() {

    private val binding : FragmentAllAccountBinding by lazy { FragmentAllAccountBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val adapter = AnimationAdapter()
//        binding.viewPager.adapter = adapter
//        adapter.submitList(setAdapter())

    }

    private fun setAdapter() : List<TenantDetail>{
        val list = mutableListOf<TenantDetail>()

        list.add(
            TenantDetail(
                tenantName = "홍길동",
                buildingName = "원랩빌딩(1/3)",
                area = "108㎡",
                contractPeriod = "2020.01.02 ~2023.01.02 (D-35)",
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
                contractPeriod = "2020.01.02 ~2024.01.02 (D-350)",
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
                contractPeriod = "2020.01.02 ~2023.01.02 (D-35)",
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