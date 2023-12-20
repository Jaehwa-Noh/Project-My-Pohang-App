package com.example.mypohangapp.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mypohangapp.model.Category


@Composable
fun MyPohangNavigationRail(
    categories: List<Category>,
    selectedCategory: Category?,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier
    ) {
        categories.forEach { category ->
            NavigationRailItem(
                selected = selectedCategory == category,
                onClick = { onClick(category) },
                icon = {
                    Icon(
                        painterResource(id = category.iconId),
                        contentDescription = null
                    )
                },
                label = { Text(stringResource(id = category.categoryName)) })
        }
    }
}
