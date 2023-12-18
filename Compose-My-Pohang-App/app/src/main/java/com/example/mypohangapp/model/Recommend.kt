package com.example.mypohangapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommend(
    val categoryType: CategoryType,
    @StringRes val name: Int,
    @StringRes val location: Int,
    @StringRes val information: Int,
    @StringRes val source: Int,
    @DrawableRes val picture: Int
)
