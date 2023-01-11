package ru.uspehovmax.fragmentcolor

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Color(
    val name: String, //  = "Green"
    val number: Int //= R.color.green
): Parcelable
