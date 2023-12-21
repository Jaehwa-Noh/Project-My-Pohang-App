package com.example.mypohangapp

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.espresso.Espresso
import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.CategoryType
import com.example.mypohangapp.ui.MyPohangApp
import com.example.mypohangapp.ui.PohangScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MyPohangAppCompactScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    @TestCompactWidth
    fun setupCompactMyPohangNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MyPohangApp(
                windowSize = WindowWidthSizeClass.Compact,
                navController = navController
            )
        }
    }

    @Test
    @TestCompactWidth
    fun compactDevice_MyPohangNavHost_VerifyStartDestination() {
        navController.assertCurrentRouteName(PohangScreen.Category.name)
    }

    @Test
    @TestCompactWidth
    fun compactDevice_MyPohangNavHost_VerifyBackNavigationNotShowOnCategory() {
        composeTestRule.onNodeWithDescriptionId(R.string.back_button)
            .assertDoesNotExist()
    }

    @Test
    @TestCompactWidth
    fun compactDevice_CategoryScreen_VerifyContent() {
        val categories = CategoryAndRecommendRepository.categories
        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestCompactWidth
    fun compactDevice_ClickCategory_NavigatesToRecommendScreen() {
        navigateCoffeeToRecommendScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.Recommend.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .assertIsDisplayed()
    }

    @Test
    @TestCompactWidth
    fun compactDevice_RecommendScreen_VerifyContent() {
        navigateCoffeeToRecommendScreen(composeTestRule)
        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.categoryType == CategoryType.CoffeeShop
        }.forEach {
            composeTestRule.onNodeWithStringId(it.name)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestCompactWidth
    fun compactDevice_BackPress_NavigatesRecommendToCategoryScreen() {
        navigateCoffeeToRecommendScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.Recommend.name)
        Espresso.pressBack()
        navController.assertCurrentRouteName(PohangScreen.Category.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .assertDoesNotExist()
    }

    @Test
    @TestCompactWidth
    fun compactDevice_ClickRecommend_NavigatesRecommendToDetailScreen() {
        navigateRecommendToDetailScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.RecommendDetail.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_detail)
            .assertIsDisplayed()
    }

    @Test
    @TestCompactWidth
    fun compactDevice_RecommendDetailScreen_VerifyContent() {
        navigateRecommendToDetailScreen(composeTestRule)
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
    }

    @Test
    @TestCompactWidth
    fun compactDevice_DoubleBack_NavigatesDetailToCategoryScreen() {
        navigateRecommendToDetailScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.RecommendDetail.name)
        composeTestRule.onNodeWithDescriptionId(R.string.back_button)
            .performClick()
        navController.assertCurrentRouteName(PohangScreen.Recommend.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_information)
            .assertDoesNotExist()
        composeTestRule.onNodeWithDescriptionId(R.string.back_button)
            .performClick()
        navController.assertCurrentRouteName(PohangScreen.Category.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .assertDoesNotExist()
        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .assertIsDisplayed()
    }

}