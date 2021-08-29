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

class AllAccountFragment : Fragment() {

    private val binding : FragmentAllAccountBinding by lazy { FragmentAllAccountBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AnimationAdapter()
        binding.viewPager.adapter = adapter
        adapter.submitList(setAdapter())

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

}