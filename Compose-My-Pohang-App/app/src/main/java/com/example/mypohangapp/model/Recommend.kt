package com.example.mypohangapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mypohangapp.R

data class Recommend(
    val categoryType: CategoryType,
    @StringRes val name: Int,
    @StringRes val location: Int,
    @StringRes val information: Int,
    @StringRes val source: Int = R.string.recommend_source,
    @DrawableRes val picture: Int
)
