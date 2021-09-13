package com.example.etcstudy

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.CycleInterpolator
import com.example.etcstudy.databinding.ActivityObjectAnimatorBinding

// 자료 출처 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=tkddlf4209&logNo=221638722158
class ObjectAnimatorActivity : AppCompatActivity() {

    private val binding : ActivityObjectAnimatorBinding by lazy { ActivityObjectAnimatorBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            binding.qrImg.animate().apply {
                alpha(0.5f)
                scaleX(1.5f)
                scaleY(1.5f)
                duration = 1000
                withEndAction {
                    val transitionValue = binding.qrImg.height.toFloat()
                    ObjectAnimator.ofFloat(binding.scanLine, "translationY", transitionValue).apply {
                        duration = 2000
                        repeatCount = ValueAnimator.INFINITE
                        repeatMode = ValueAnimator.REVERSE
                        start()
//                interpolator = CycleInterpolator(1f)
                interpolator = AccelerateDecelerateInterpolator()
                    }

                    ObjectAnimator.ofInt(0, binding.qrImg.height).apply {
                        duration = 2000
                        repeatCount = ValueAnimator.INFINITE
                        repeatMode = ValueAnimator.REVERSE
                        addUpdateListener {
                            binding.scanFill.layoutParams.height = it.animatedValue as Int
                            binding.scanFill.requestLayout()
                        }
                        start()
                    }


//                    {
//    ObjectAnimator().apply {
//      setAutoCancel(false)
//      target = anchorNode
//      duration = durationTime
//      setObjectValues(
//        anchorNode.localPosition,
//        targetPosition
//      )
//      setPropertyName("localPosition")
//      setEvaluator(Vector3Evaluator())
//      interpolator = AccelerateDecelerateInterpolator()
//      start()
//    }.doWhenFinish { doWhenFinish() }
                }
            }



        }, 300)

    }
}