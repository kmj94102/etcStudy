package com.example.etcstudy.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
    this.startActivity(Intent(this, T::class.java))

fun Context.toast(message : String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()