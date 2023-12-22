package com.example.mypohangapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mypohangapp.R

enum class CategoryType(@StringRes val title: Int) {
    CoffeeShop(title = R.string.coffee_shop),
    Restaurants(title = R.string.restaurants),
    KidFriendly(title = R.string.kid_friendly),
    Parks(title = R.string.parks),
    Shopping(title = R.string.shopping_centers)
}

@DrawableRes
fun CategoryType.getIcon(): Int {
    return when (this) {
        CategoryType.CoffeeShop -> {
            R.drawable.local_cafe_24px
        }

        CategoryType.Restaurants -> {
            R.drawable.restaurant_24px
        }

        CategoryType.KidFriendly -> {
            R.drawable.family_restroom_24px
        }

        CategoryType.Parks -> {
            R.drawable.park_24px
        }

        CategoryType.Shopping -> {
            R.drawable.shopping_bag_24px
        }
    }
}