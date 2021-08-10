package com.example.etcstudy.scoll_image

import android.graphics.Canvas

abstract class ViewTransformer {

    /**
     * This will be called when it's being set into the ScrollTransformImageView
     * 이것은 ScrollTransformImageView 로 설정될 때 호출됩니다.
     */
    open fun onAttached(view : ScrollTransformImageView) {}

    /**
     * This will be called when it's being removed or replaced by other viewTransformer
     * from the ScrollTransformImageView
     * ScrollTransformImageView 에서 다른 viewTransformer 로 제거되거나 대체될 때 호출됩니다.
     */
    open fun onDetached(view : ScrollTransformImageView) {}

    /**
     * apply will be called every time the view scrolled and before rendered
     * 뷰가 스크롤될 때마다 그리고 렌더링되기 전에 apply가 호출됩니다.
     */
    abstract fun apply(view: ScrollTransformImageView, canvas: Canvas, viewX : Int, viewY : Int)

    /**
     * Convert top,left (0,0) coordinate
     * to the middle of the screen
     * 위, 왼쪽(0,0) 좌표를 화면 중앙으로 변환
     */
    protected fun centeredX(x : Int, viewWidth : Int, screenWidth : Int) = x + (viewWidth / 2) - (screenWidth / 2)
    protected fun centeredY(y : Int, viewHeight : Int, screenHeight : Int) = (screenHeight / 2) - (y + (viewHeight / 2))
}