package com.example.etcstudy.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Parcelable
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.example.etcstudy.transform.TestItem
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
    this.startActivity(Intent(this, T::class.java))

inline fun <reified T: Activity, E> Context.transformStartActivity(transformationLayout: TransformationLayout, item : E){
    val intent = Intent(this, T::class.java)

    if(item is Parcelable){
        intent.putExtra(Constraint.INTENT_TRANSFORM_PARAM, item)
    }
    TransformationCompat.startActivity(transformationLayout, intent)
}

fun Context.toast(message : String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun View.setLayoutMarginTop(dimen: Float){
    val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    val dp = this.context.resources.displayMetrics
    layoutParams.topMargin = (dimen * dp.density).roundToInt()
    this.layoutParams = layoutParams
}

fun View.setLayoutMarginBottom(dimen: Float){
    val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    val dp = this.context.resources.displayMetrics
    layoutParams.bottomMargin = (dimen * dp.density).roundToInt()
    this.layoutParams = layoutParams
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

fun Date.toString(format: String, locale: Locale = Locale.KOREA): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

val Int.dp : Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

fun dpToPx(context: Context, dp: Float) : Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)