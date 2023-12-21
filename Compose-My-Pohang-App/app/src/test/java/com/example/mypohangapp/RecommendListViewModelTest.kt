package com.example.mypohangapp

import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.ui.RecommendListViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class RecommendListViewModelTest {
    private val recommendListViewModel = RecommendListViewModel()

    @Test
    fun recommendListViewModel_SelectedCategory_CheckCategoryAndRecommendsSuccess() {
        val newCategory = CategoryAndRecommendRepository.categories[0]
        recommendListViewModel.setSelectedCategory(category = newCategory)
        val currentUiState = recommendListViewModel.uiState.value

        assertEquals(newCategory, currentUiState.selectedCategory)

        val recommend = CategoryAndRecommendRepository.recommends.filter {
            it.categoryType == currentUiState.selectedCategory?.category
        }

        assertEquals(recommend, currentUiState.recommends)
    }

    @Test
    fun recommendListViewModel_SelectedCategory_CheckCategoryAndRecommendsFail() {
        val newCategory = CategoryAndRecommendRepository.categories[0]
        recommendListViewModel.setSelectedCategory(category = newCategory)
        val currentUiState = recommendListViewModel.uiState.value

        assertNotEquals(
            CategoryAndRecommendRepository.categories[1],
            currentUiState.selectedCategory
        )

        val recommend = CategoryAndRecommendRepository.recommends.filter {
            it.categoryType == CategoryAndRecommendRepository.categories[1].category
        }

        assertNotEquals(recommend, currentUiState.recommends)
    }

    @Test
    fun recommendListViewModel_SelectedCategory_CheckCategoryAndRecommendsEdge() {
        val categories = CategoryAndRecommendRepository.categories

        categories.forEach { category ->
            recommendListViewModel.setSelectedCategory(category = category)
            val currentUiState = recommendListViewModel.uiState.value
            assertEquals(category, currentUiState.selectedCategory)

            val recommend = CategoryAndRecommendRepository.recommends.filter {
                it.categoryType == category.category
            }

            assertEquals(recommend, currentUiState.recommends)
        }
    }
}