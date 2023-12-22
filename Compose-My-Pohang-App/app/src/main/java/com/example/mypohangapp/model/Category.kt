package com.example.mypohangapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Category(
    val category: CategoryType,
    @StringRes val categoryName: Int = CategoryType.valueOf(category.name).title,
    @DrawableRes val iconId: Int = category.getIcon()
)
