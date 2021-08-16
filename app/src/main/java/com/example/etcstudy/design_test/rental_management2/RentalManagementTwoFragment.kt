package com.example.etcstudy.design_test.rental_management2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.etcstudy.R
import com.example.etcstudy.databinding.FragmentRentalManagementTwoBinding
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

}