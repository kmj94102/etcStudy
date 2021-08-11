package com.example.etcstudy.transform

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestItem(
    val title : String,
    val content : String
): Parcelable