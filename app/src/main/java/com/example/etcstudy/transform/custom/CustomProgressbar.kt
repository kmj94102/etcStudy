package com.example.etcstudy.transform.custom

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet

open class CustomProgressbar : androidx.appcompat.widget.AppCompatSeekBar {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    var mProgressItemList : ArrayList<ProgressItem> = arrayListOf()
    fun initData(mProgressItemList : ArrayList<ProgressItem>){
        progressDrawable = null
        thumb = null
        this.mProgressItemList = mProgressItemList
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // todo Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas){
        if(mProgressItemList.size > 0){
            val progressBarWidth = width.toFloat()
            val progressBarHeight = height.toFloat()
            val thumbOffset = thumbOffset
            var progressItemWidth: Float

            mProgressItemList.forEach { progressItem ->
                val progressPaint = Paint()
                progressPaint.color = resources.getColor(progressItem.color)
                progressItemWidth = (progressItem.progressItemPercentage * progressBarWidth / 100)

                val progressRect = RectF()
                progressRect.set(0f, (thumbOffset / 2).toFloat(), progressItemWidth, progressBarHeight - thumbOffset / 2)

                canvas.drawRoundRect(progressRect, 20f, 20f, progressPaint)
            }
            super.onDraw(canvas)
        }
    }
}
