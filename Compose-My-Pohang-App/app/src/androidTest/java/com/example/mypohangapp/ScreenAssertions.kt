package com.example.mypohangapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.NavController
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.mypohangapp.model.Recommend
import org.junit.Assert.assertEquals

fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}

fun checkAllNodeInRecommendDetail(
    composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>,
    recommend: Recommend
) {
    composeTestRule.onNodeWithTag(composeTestRule.tag(R.string.test_tag_recommend_detail_text_area))
        .onChildren()
        .assertAny(
            hasText(
                composeTestRule.activity.getString(recommend.name)
            )
        )
        .assertAny(
            hasText(
                composeTestRule.activity.getString(recommend.location)
            )
        )
        .assertAny(
            hasText(
                composeTestRule.activity.getString(recommend.information)
            )
        )
        .assertAny(
            hasText(
                composeTestRule.activity.getString(recommend.source)
            )
        )
    composeTestRule.onNodeWithTag(composeTestRule.tag(R.string.test_tag_detail_picture))
}