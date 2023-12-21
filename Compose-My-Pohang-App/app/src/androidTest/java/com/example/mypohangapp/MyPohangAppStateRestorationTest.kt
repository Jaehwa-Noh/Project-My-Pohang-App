package com.example.mypohangapp

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.CategoryType
import com.example.mypohangapp.ui.MyPohangApp
import org.junit.Rule
import org.junit.Test

class MyPohangAppStateRestorationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    @TestCompactWidth
    fun compactDevice_CategoryScreenRetained_AfterConfigChange() {

        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Compact)
        }

        val categories = CategoryAndRecommendRepository.categories
        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestCompactWidth
    fun compactDevice_RecommendScreenRetain_AfterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Compact)
        }

        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .performClick()

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestCompactWidth
    fun compactDevice_RecommendDetailScreenRetain_AfterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Compact)
        }

        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .performClick()

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.location)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.information)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(
                composeTestRule.tag(R.string.test_tag_detail_picture)
            ).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.source)
                .assertExists()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.location)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.information)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(
                composeTestRule.tag(R.string.test_tag_detail_picture)
            ).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.source)
                .assertExists()
        }
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_CategoryScreenRetained_AfterConfigChange() {

        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Medium)
        }

        val categories = CategoryAndRecommendRepository.categories
        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_RecommendScreenRetain_AfterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Medium)
        }

        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .performClick()

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_RecommendDetailScreenRetain_AfterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Medium)
        }

        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .performClick()

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.location)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.information)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(
                composeTestRule.tag(R.string.test_tag_detail_picture)
            ).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.source)
                .assertExists()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.location)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.information)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(
                composeTestRule.tag(R.string.test_tag_detail_picture)
            ).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.source)
                .assertExists()
        }
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_CategoryScreenRetained_AfterConfigChange() {

        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        val categories = CategoryAndRecommendRepository.categories
        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_RecommendScreenRetain_AfterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .performClick()

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_RecommendDetailScreenRetain_AfterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent {
            MyPohangApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .performClick()

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.location)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.information)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(
                composeTestRule.tag(R.string.test_tag_detail_picture)
            ).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.source)
                .assertExists()
        }

        stateRestorationTester.emulateSavedInstanceStateRestore()

        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.location)
                .assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.information)
                .assertIsDisplayed()
            composeTestRule.onNodeWithTag(
                composeTestRule.tag(R.string.test_tag_detail_picture)
            ).assertIsDisplayed()
            composeTestRule.onNodeWithStringId(it.source)
                .assertExists()
        }
    }

}