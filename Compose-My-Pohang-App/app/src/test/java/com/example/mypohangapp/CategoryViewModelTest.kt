package com.example.mypohangapp

import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.ui.CategoryUiState
import com.example.mypohangapp.ui.CategoryViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class CategoryViewModelTest {
    private val viewModel = CategoryViewModel()

    @Test
    fun categoryViewModel_SelectCategory_CategorySetByNewCategorySuccess() {

        val newCategory = CategoryAndRecommendRepository.categories[0]
        viewModel.selectCategory(
            category = newCategory
        )

        val currentCategoryUiState: CategoryUiState = viewModel.uiState.value

        assertEquals(newCategory, currentCategoryUiState.selectedCategory)
    }

    @Test
    fun categoryViewModel_SelectCategory_CategorySetAndFail() {

        val newCategory = CategoryAndRecommendRepository.categories[1]
        viewModel.selectCategory(
            category = newCategory
        )

        val currentCategoryUiState: CategoryUiState = viewModel.uiState.value

        assertNotEquals(
            CategoryAndRecommendRepository.categories[0],
            currentCategoryUiState.selectedCategory
        )
    }

    @Test
    fun categoryViewModel_SelectCategory_ChangeAllCategoryEdge() {

        val newCategories = CategoryAndRecommendRepository.categories
        newCategories.forEach { newCategory ->
            viewModel.selectCategory(
                category = newCategory
            )
            val currentCategoryUiState = viewModel.uiState.value
            assertEquals(newCategory, currentCategoryUiState.selectedCategory)
        }
    }

    @Test
    fun categoryViewModel_ClearCategory_SetAndClearCategorySuccess() {
        val currentCategoryUiState = viewModel.uiState.value

        val newCategory = CategoryAndRecommendRepository.categories[0]
        viewModel.selectCategory(
            category = newCategory
        )
        viewModel.clearCategory()

        assertEquals(null, currentCategoryUiState.selectedCategory)

    }

    @Test
    fun categoryViewModel_ClearCategory_SetAndClearCategoryFail() {
        val currentCategoryUiState = viewModel.uiState.value

        val newCategory = CategoryAndRecommendRepository.categories[1]
        viewModel.selectCategory(
            category = newCategory
        )
        viewModel.clearCategory()

        assertNotEquals(newCategory, currentCategoryUiState.selectedCategory)
    }

    @Test
    fun categoryViewModel_ClearCategory_SetAndClearAllCategoryEdge() {
        val newCategories = CategoryAndRecommendRepository.categories

        newCategories.forEach { newCategory ->
            viewModel.selectCategory(
                category = newCategory
            )
            viewModel.clearCategory()
            val currentCategoryUiState = viewModel.uiState.value
            assertEquals(null, currentCategoryUiState.selectedCategory)
        }
    }


}