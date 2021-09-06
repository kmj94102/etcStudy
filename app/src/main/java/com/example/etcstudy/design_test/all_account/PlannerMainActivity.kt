package com.example.etcstudy.design_test.all_account

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.util.TypedValue
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.etcstudy.R
import com.example.etcstudy.databinding.ActivityPlannerMainBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import java.util.logging.Handler

class PlannerMainActivity : AppCompatActivity() {

    private val binding : ActivityPlannerMainBinding by lazy { ActivityPlannerMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setChart(binding.chart)
        binding.chart

        initViews()

    }

    private fun setChart(chart: PieChart) {
        chart.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(7f, ""))
        entries.add(PieEntry(2f, ""))
        entries.add(PieEntry(3f, ""))

        val colorsItems = arrayListOf(
            ContextCompat.getColor(this, R.color.sky_blue),
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.yellow)
        )

        val pieDataSet = PieDataSet(entries, "").apply {
            colors = colorsItems
            valueTextSize = 0f
            sliceSpace = 5f
            selectionShift = 14f
        }

        val pieData = PieData(pieDataSet)
        chart.apply {
            data = pieData
            // 차트 설명 표시 여부
            description.isEnabled = false
            // 차트 회전 여부
            isRotationEnabled = false
            // 차트 범례 표시여부
            legend.isEnabled = false
            // 차트 영역 라운드 범위 및 색상
            transparentCircleRadius = 65f
            isDrawHoleEnabled = true
            setHoleColor(android.R.color.transparent)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

    }

    private fun initViews() = with(binding){


        imgMore.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            if (layoutBottom.tag == "false"){
                val height = (root.bottom - txtPride.bottom - dpToPx(this@PlannerMainActivity, 120f) ).toInt()
                val layoutParams = layoutBottom.layoutParams
                layoutParams.height = height
                layoutBottom.layoutParams = layoutParams

                layoutBottom.tag = "true"
                viewMore.setBackgroundResource(R.drawable.ic_chevron_down_bold)
            }else{
                val layoutParams = layoutBottom.layoutParams
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                layoutBottom.layoutParams = layoutParams

                layoutBottom.tag = "false"
                viewMore.setBackgroundResource(R.drawable.ic_chevron_up_bold)
            }
        }
    }

    val Int.dp : Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    fun dpToPx(context: Context, dp: Float) : Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
}