package com.example.etcstudy.design_test.all_account

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2

// https://www.youtube.com/watch?v=eK8fo-Eznw4
class ViewPagerStack : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        ViewCompat.setElevation(page, -kotlin.math.abs(position))
        if(position > 3){
            page.translationX = -page.width * position
            page.translationY = -90 * position
            page.scaleX = 0f
            page.scaleY = 0f
        }
        else if(position >= 0){
            page.scaleX = 0.8f - 0.09f * position
            page.scaleY = 0.7f

            page.translationX = -page.width * position
            page.translationY = -130 * position
        }
    }
}