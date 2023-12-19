package com.example.mypohangapp.ui

import androidx.lifecycle.ViewModel
import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.Category
import com.example.mypohangapp.model.Recommend
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecommendListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RecommendListUIState())
    val uiState: StateFlow<RecommendListUIState> = _uiState.asStateFlow()

    fun setSelectedCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = category,
                recommends = getCategoryFromRepository(category)
            )
        }
    }

    private fun getCategoryFromRepository(category: Category): List<Recommend> {
        return CategoryAndRecommendRepository.recommends.filter {
            it.categoryType == category.category
        }
    }
}

data class RecommendListUIState(
    val selectedCategory: Category? = null,
    val recommends: List<Recommend> = emptyList(),
    val selectedRecommend: Recommend? = null
)