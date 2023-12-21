package com.example.mypohangapp

import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.Recommend
import com.example.mypohangapp.ui.RecommendDetailViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class RecommendDetailViewModelTest {
    private val recommendDetailViewModel = RecommendDetailViewModel()

    @Test
    fun recommendDetailViewModel_setRecommend_SetRecommendSuccess() {
        val newRecommend = CategoryAndRecommendRepository.recommends[0]
        recommendDetailViewModel.setRecommend(newRecommend)
        val currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

        assertEquals(newRecommend, currentRecommendDetailUIState.recommend)
    }

    @Test
    fun recommendDetailViewModel_setRecommend_SetRecommendFail() {
        val newRecommend = CategoryAndRecommendRepository.recommends[1]
        recommendDetailViewModel.setRecommend(newRecommend)
        val currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

        assertNotEquals(
            CategoryAndRecommendRepository.recommends[0],
            currentRecommendDetailUIState.recommend
        )
    }

    @Test
    fun recommendDetailViewModel_setRecommend_SetRecommendEdge() {
        val recommends = CategoryAndRecommendRepository.recommends
        recommends.forEach { recommend ->
            recommendDetailViewModel.setRecommend(recommend)
            val currentRecommendDetailUIState = recommendDetailViewModel.uiState.value
            assertEquals(recommend, currentRecommendDetailUIState.recommend)
        }
    }

    @Test
    fun recommendDetailViewModel_clearRecommend_SetRecommendSuccess() {
        val newRecommend = CategoryAndRecommendRepository.recommends[0]
        recommendDetailViewModel.setRecommend(newRecommend)
        var currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

        assertEquals(newRecommend, currentRecommendDetailUIState.recommend)

        recommendDetailViewModel.clearRecommend()
        currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

        assertEquals(null, currentRecommendDetailUIState.recommend)
    }

    @Test
    fun recommendDetailViewModel_clearRecommend_SetRecommendFail() {
        val newRecommend = CategoryAndRecommendRepository.recommends[0]
        recommendDetailViewModel.setRecommend(newRecommend)
        var currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

        assertEquals(newRecommend, currentRecommendDetailUIState.recommend)

        recommendDetailViewModel.clearRecommend()
        currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

        assertNotEquals(newRecommend, currentRecommendDetailUIState.recommend)
    }

    @Test
    fun recommendDetailViewModel_clearRecommend_SetRecommendEdge() {

        val recommends = CategoryAndRecommendRepository.recommends
        recommends.forEach { recommend: Recommend ->
            recommendDetailViewModel.setRecommend(recommend)
            var currentRecommendDetailUIState = recommendDetailViewModel.uiState.value
            assertEquals(recommend, currentRecommendDetailUIState.recommend)

            recommendDetailViewModel.clearRecommend()
            currentRecommendDetailUIState = recommendDetailViewModel.uiState.value

            assertEquals(null, currentRecommendDetailUIState.recommend)
        }
    }
}