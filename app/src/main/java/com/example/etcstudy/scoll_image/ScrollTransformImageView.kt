package com.example.etcstudy.scoll_image

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewTreeObserver

open class ScrollTransformImageView : androidx.appcompat.widget.AppCompatImageView, ViewTreeObserver.OnScrollChangedListener {

    private val viewLocation : IntArray = IntArray(2)

    var viewTransformer : ViewTransformer? = null
        set(value) {
            field?.onDetached(this)
            field = value
            field?.onAttached(this)
        }
    var enableTransformer : Boolean = true

    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attributeSet: AttributeSet) : super(ctx, attributeSet)

    init {
        viewTransformer = VerticalParallaxTransformer()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewTreeObserver.addOnScrollChangedListener(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewTreeObserver.removeOnScrollChangedListener(this)
    }

    override fun onDraw(canvas: Canvas) {
        if (enableTransformer) {
            getLocationInWindow(viewLocation)
            viewTransformer?.apply(this, canvas, viewLocation[0], viewLocation[1])
        }
        super.onDraw(canvas)
    }

    override fun onScrollChanged() {
        if (enableTransformer) invalidate()
    }
}