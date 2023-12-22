package com.example.mypohangapp

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
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

class MyPohangAppExpandedScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    @TestExpandedWidth
    fun setupExpendedMyPohangNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MyPohangApp(
                windowSize = WindowWidthSizeClass.Expanded,
                navController = navController
            )
        }
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_MyPohangNavHost_VerifyStartDestination() {
        navController.assertCurrentRouteName(PohangScreen.Category.name)
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_MyPohangNavHost_VerifyBackNavigationNotShowOnCategory() {
        composeTestRule.onNodeWithDescriptionId(R.string.back_button)
            .assertDoesNotExist()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_CategoryScreen_VerifyContent() {
        val categories = CategoryAndRecommendRepository.categories
        categories.forEach { category ->
            composeTestRule.onNodeWithStringId(category.categoryName)
                .assertIsDisplayed()
        }
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_ClickCategory_NavigatesToRecommendScreen() {
        navigateCoffeeToRecommendScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.Recommend.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .assertIsDisplayed()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_RecommendScreen_VerifyContent() {
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
    @TestExpandedWidth
    fun expandedDevice_BackPress_NavigatesRecommendToCategoryScreen() {
        navigateCoffeeToRecommendScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.Recommend.name)
        Espresso.pressBack()
        navController.assertCurrentRouteName(PohangScreen.Category.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .assertDoesNotExist()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_ClickRecommend_NavigatesRecommendToDetailScreen() {
        navigateRecommendToDetailScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.RecommendDetail.name)
        composeTestRule.onNodeWithTag(composeTestRule.tag(R.string.test_tag_recommend_detail_text_area))
            .assertIsDisplayed()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_RecommendDetailScreen_VerifyContent() {
        navigateRecommendToDetailScreen(composeTestRule)
        val recommends = CategoryAndRecommendRepository.recommends
        recommends.filter {
            it.name == R.string.recommend_1_title
        }.forEach {
            checkAllNodeInRecommendDetail(composeTestRule, it)
        }
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_DoubleBack_NavigatesDetailToCategoryScreen() {
        navigateRecommendToDetailScreen(composeTestRule)
        navController.assertCurrentRouteName(PohangScreen.RecommendDetail.name)
        composeTestRule.onNodeWithDescriptionId(R.string.back_button)
            .assertDoesNotExist()
        Espresso.pressBack()
        navController.assertCurrentRouteName(PohangScreen.Recommend.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_information)
            .assertDoesNotExist()
        composeTestRule.onNodeWithDescriptionId(R.string.back_button)
            .assertDoesNotExist()
        Espresso.pressBack()
        navController.assertCurrentRouteName(PohangScreen.Category.name)
        composeTestRule.onNodeWithStringId(R.string.recommend_1_title)
            .assertDoesNotExist()
        composeTestRule.onNodeWithStringId(R.string.coffee_shop)
            .assertIsDisplayed()
    }
}