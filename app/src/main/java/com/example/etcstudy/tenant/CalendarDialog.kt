package com.example.etcstudy.tenant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import com.example.etcstudy.R
import com.example.etcstudy.databinding.BottomSheetDialogCalendarBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CalendarDialog(private val defaultSelectedDate : Int, private val listener: () -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding : BottomSheetDialogCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = BottomSheetDialogCalendarBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

    }

    private fun initViews() = with(binding) {
        textViewCancel.setOnClickListener { dismiss() }
        textViewSave.setOnClickListener {
            listener()
        }

        calendarGroup.forEach { item ->
            item.setOnClickListener { onClickCalendarItem(item) }
        }


        (calendarGroup.getChildAt(defaultSelectedDate - 1) as? CustomCalendarItem)?.isSelected = true

    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialog
    }

    private fun onClickCalendarItem(item: View) {
        if (item !is CustomCalendarItem) return
        item.isSelected = true
    }

}
