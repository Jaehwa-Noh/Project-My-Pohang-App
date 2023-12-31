package com.example.mypohangapp.ui

import androidx.lifecycle.ViewModel
import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CategoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CategoryUiState())
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val categories = CategoryAndRecommendRepository.categories

        _uiState.value = CategoryUiState(
            categories = categories
        )
    }

    fun selectCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = category
            )
        }
    }

    fun clearCategory() {
        _uiState.update {currentState ->
            currentState.copy(
                selectedCategory = null
            )
        }
    }
}

data class CategoryUiState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null

)