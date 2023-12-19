package com.example.mypohangapp.ui

import androidx.lifecycle.ViewModel
import com.example.mypohangapp.model.Recommend
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecommendDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RecommendDetailUIState())
    val uiState: StateFlow<RecommendDetailUIState> = _uiState.asStateFlow()

    fun setRecommend(recommend: Recommend) {
        _uiState.update { currentState ->
            currentState.copy(
                recommend = recommend
            )
        }
    }
}

data class RecommendDetailUIState(
    val recommend: Recommend? = null
)