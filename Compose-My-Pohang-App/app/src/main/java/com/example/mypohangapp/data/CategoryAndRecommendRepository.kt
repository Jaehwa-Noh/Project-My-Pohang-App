package com.example.mypohangapp.data

import com.example.mypohangapp.R
import com.example.mypohangapp.model.Category
import com.example.mypohangapp.model.CategoryType
import com.example.mypohangapp.model.Recommend

object CategoryAndRecommendRepository {
    val categories = listOf(
        Category(
            category = CategoryType.CoffeeShop
        ),
        Category(
            category = CategoryType.Restaurants
        ),
        Category(
            category = CategoryType.KidFriendly
        ),
        Category(
            category = CategoryType.Parks
        ),
        Category(
            category = CategoryType.Shopping
        )
    )

    val recommends = listOf(
        Recommend(
            categoryType = CategoryType.CoffeeShop,
            name = R.string.recommend_1_title,
            location = R.string.recommend_1_location,
            information = R.string.recommend_1_information,
            picture = R.drawable.recommend_1
        ),
        Recommend(
            categoryType = CategoryType.CoffeeShop,
            name = R.string.recommend_2_title,
            location = R.string.recommend_2_location,
            information = R.string.recommend_2_information,
            picture = R.drawable.recommend_2
        ),
        Recommend(
            categoryType = CategoryType.CoffeeShop,
            name = R.string.recommend_3_title,
            location = R.string.recommend_3_location,
            information = R.string.recommend_3_information,
            picture = R.drawable.recommend_3
        ),
        Recommend(
            categoryType = CategoryType.CoffeeShop,
            name = R.string.recommend_4_title,
            location = R.string.recommend_4_location,
            information = R.string.recommend_4_information,
            picture = R.drawable.recommend_4
        ),
        Recommend(
            categoryType = CategoryType.CoffeeShop,
            name = R.string.recommend_5_title,
            location = R.string.recommend_5_location,
            information = R.string.recommend_5_information,
            picture = R.drawable.recommend_5
        ),
        Recommend(
            categoryType = CategoryType.Restaurants,
            name = R.string.recommend_6_title,
            location = R.string.recommend_6_location,
            information = R.string.recommend_6_information,
            picture = R.drawable.recommend_6
        ),
        Recommend(
            categoryType = CategoryType.Restaurants,
            name = R.string.recommend_7_title,
            location = R.string.recommend_7_location,
            information = R.string.recommend_7_information,
            picture = R.drawable.recommend_7
        ),
        Recommend(
            categoryType = CategoryType.Restaurants,
            name = R.string.recommend_8_title,
            location = R.string.recommend_8_location,
            information = R.string.recommend_8_information,
            picture = R.drawable.recommend_8
        ),
        Recommend(
            categoryType = CategoryType.Restaurants,
            name = R.string.recommend_9_title,
            location = R.string.recommend_9_location,
            information = R.string.recommend_9_information,
            picture = R.drawable.recommend_9
        ),
        Recommend(
            categoryType = CategoryType.Restaurants,
            name = R.string.recommend_10_title,
            location = R.string.recommend_10_location,
            information = R.string.recommend_10_information,
            picture = R.drawable.recommend_10
        ),
        Recommend(
            categoryType = CategoryType.KidFriendly,
            name = R.string.recommend_11_title,
            location = R.string.recommend_11_location,
            information = R.string.recommend_11_information,
            picture = R.drawable.recommend_11
        ),
        Recommend(
            categoryType = CategoryType.KidFriendly,
            name = R.string.recommend_12_title,
            location = R.string.recommend_12_location,
            information = R.string.recommend_12_information,
            picture = R.drawable.recommend_12
        ),
        Recommend(
            categoryType = CategoryType.KidFriendly,
            name = R.string.recommend_13_title,
            location = R.string.recommend_13_location,
            information = R.string.recommend_13_information,
            picture = R.drawable.recommend_13
        ),
        Recommend(
            categoryType = CategoryType.KidFriendly,
            name = R.string.recommend_14_title,
            location = R.string.recommend_14_location,
            information = R.string.recommend_14_information,
            picture = R.drawable.recommend_14
        ),
        Recommend(
            categoryType = CategoryType.KidFriendly,
            name = R.string.recommend_15_title,
            location = R.string.recommend_15_location,
            information = R.string.recommend_15_information,
            picture = R.drawable.recommend_15
        ),
        Recommend(
            categoryType = CategoryType.Parks,
            name = R.string.recommend_16_title,
            location = R.string.recommend_16_location,
            information = R.string.recommend_16_information,
            picture = R.drawable.recommend_16
        ),
        Recommend(
            categoryType = CategoryType.Parks,
            name = R.string.recommend_17_title,
            location = R.string.recommend_17_location,
            information = R.string.recommend_17_information,
            picture = R.drawable.recommend_17
        ),
        Recommend(
            categoryType = CategoryType.Parks,
            name = R.string.recommend_18_title,
            location = R.string.recommend_18_location,
            information = R.string.recommend_18_information,
            picture = R.drawable.recommend_18
        ),
        Recommend(
            categoryType = CategoryType.Parks,
            name = R.string.recommend_19_title,
            location = R.string.recommend_19_location,
            information = R.string.recommend_19_information,
            picture = R.drawable.recommend_19
        ),
        Recommend(
            categoryType = CategoryType.Parks,
            name = R.string.recommend_20_title,
            location = R.string.recommend_20_location,
            information = R.string.recommend_20_information,
            picture = R.drawable.recommend_20
        ),
        Recommend(
            categoryType = CategoryType.Shopping,
            name = R.string.recommend_21_title,
            location = R.string.recommend_21_location,
            information = R.string.recommend_21_information,
            picture = R.drawable.recommend_21
        ),
        Recommend(
            categoryType = CategoryType.Shopping,
            name = R.string.recommend_22_title,
            location = R.string.recommend_22_location,
            information = R.string.recommend_22_information,
            picture = R.drawable.recommend_22
        ),
        Recommend(
            categoryType = CategoryType.Shopping,
            name = R.string.recommend_23_title,
            location = R.string.recommend_23_location,
            information = R.string.recommend_23_information,
            picture = R.drawable.recommend_23
        ),
        Recommend(
            categoryType = CategoryType.Shopping,
            name = R.string.recommend_24_title,
            location = R.string.recommend_24_location,
            information = R.string.recommend_24_information,
            picture = R.drawable.recommend_24
        ),
        Recommend(
            categoryType = CategoryType.Shopping,
            name = R.string.recommend_25_title,
            location = R.string.recommend_25_location,
            information = R.string.recommend_25_information,
            picture = R.drawable.recommend_25
        )
    )
}