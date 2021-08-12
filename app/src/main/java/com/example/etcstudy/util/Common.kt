package com.example.etcstudy.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import com.example.etcstudy.transform.TestItem
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout

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