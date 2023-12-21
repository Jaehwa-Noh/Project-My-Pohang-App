package com.example.mypohangapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule

fun navigateCoffeeToRecommendScreen(
    composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>
) {
    composeTestRule.onNodeWithStringId(R.string.coffee_shop)
        .performClick()
}

fun navigateRecommendToDetailScreen(
    composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>
) {
    navigateCoffeeToRecommendScreen(composeTestRule)
    composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
        .performClick()
}