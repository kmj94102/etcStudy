package com.example.etcstudy.image_scroll

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageItem(
    val backgroundImage : String,
    val characterImage: String,
    val backgroundColor : String,
    val title : String
) : Parcelable
