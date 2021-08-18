package com.example.etcstudy.design_test.rental_management2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentRentalManagementTwoBinding
import com.example.etcstudy.design_test.*
import com.example.etcstudy.design_test.dialog.SelectLastMonthThreeMonthDialog
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class RentalManagementTwoFragment : Fragment() {

    private val binding : FragmentRentalManagementTwoBinding by lazy { FragmentRentalManagementTwoBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setChart(binding.chart)

        setAdapter(binding.rvRentalStatus)

        setDialog()

    }

    private fun setChart(chart: PieChart) {
        chart.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(7f, ""))
        entries.add(PieEntry(2f, ""))
        entries.add(PieEntry(3f, ""))

        val colorsItems = arrayListOf(
            ContextCompat.getColor(requireContext(), R.color.sky_blue),
            ContextCompat.getColor(requireContext(), R.color.red),
            ContextCompat.getColor(requireContext(), R.color.yellow)
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
            setHoleColor(ContextCompat.getColor(requireContext(), R.color.gray_f5))
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

    }

    private fun setAdapter(recyclerView: RecyclerView){
        val adapter = RentalStatusAdapter()

        recyclerView.adapter = adapter

        adapter.submitList(getList())
    }

    private fun getList() : List<RentalStatusType> {
        val list = mutableListOf<RentalStatusType>()

        list.add(
            RentalStatusTitle().apply {
                buildingName = "가나다빌딩"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "101호"
                tenantName = "김철수"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "102호"
                tenantName = "이다니엘아"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "103호"
                tenantName = "3층 원빌딩 회읙실"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "104호"
                tenantName = "일이삼사오육칠팔구십"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "원빌딩"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "101호"
                tenantName = "원빌딩 101호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "102호"
                tenantName = "원빌딩 102호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "쓰리빌딩"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "101호"
                tenantName = "쓰리빌딩 101호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "102호"
                tenantName = "쓰리빌딩 102호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "마이빌딩"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "201호"
                tenantName = "마이빌딩 201호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "202호"
                tenantName = "마이빌딩 202호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "마이빌딩"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "302호"
                tenantName = "마이빌딩 302호"
                startMonth = "6월"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7월"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8월"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )


        return list
    }


    private fun setDialog(){
        binding.txtSelectMonth.setOnClickListener {
            SelectLastMonthThreeMonthDialog(requireContext(), 8){ _, lastMonth ->
                binding.txtSelectMonth.text = "${lastMonth}월"
            }.show()
        }
    }

}