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
            // ?????? ??????
            description.isEnabled = false
            // ?????? ?????? ?????? : 0f ~ 360f
            maxAngle = 180f
            // ?????? ??????
            rotationAngle = 180f
            // ?????? ?????? ????????????
            legend.isEnabled = false
            // ?????? ?????? ??????
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
        val tenantNameList = listOf("?????????", "???????????????", "3??? ????????? ?????????", "1??? ????????????", "?????????????????????????????????????????????", "?????????", "5??? ?????????", "?????? ?????????", "?????????", "?????? ?????????", "??????",
                                    "?????????", "?????????", "???????????????", "????????????", "?????????", "??????", "LG", "APPLE", "??????", "?????????", "??????", "?????????")

        list.add(
            RentalStatusTitle().apply {
                buildingName = "???????????????"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "101???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "102???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "103???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "104???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "?????????"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "101???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "102???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "????????????"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "101???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "102???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "????????????"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "201???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "202???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )

        list.add(
            RentalStatusTitle().apply {
                buildingName = "????????????"
            }
        )

        list.add(
            RentalStatusDetail().apply {
                ho = "302???"
                tenantName = tenantNameList.random()
                startMonth = "6???"
                startMonthStatus = Rental(PaymentStatus.values().random())
                middleMonth = "7???"
                middleMonthStatus = Rental(PaymentStatus.values().random())
                endMonth = "8???"
                endMonthStatus = Rental(PaymentStatus.values().random())
            }
        )


        return list
    }


    private fun setDialog(){
        binding.txtSelectMonth.setOnClickListener {
            SelectLastMonthThreeMonthDialog(requireContext(), 8){ _, lastMonth ->
                binding.txtSelectMonth.text = "${lastMonth}???"
            }.show()
        }
    }

}