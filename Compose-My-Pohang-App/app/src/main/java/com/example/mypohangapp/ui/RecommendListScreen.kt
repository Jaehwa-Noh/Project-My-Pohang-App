package com.example.mypohangapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecommendListScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(1) {
            RecommendListItem()
        }

    }
}

@Composable
fun RecommendListItem(modifier: Modifier = Modifier) {

}