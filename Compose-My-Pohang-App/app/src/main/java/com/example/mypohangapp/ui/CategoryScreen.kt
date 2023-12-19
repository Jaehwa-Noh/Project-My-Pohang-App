package com.example.mypohangapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mypohangapp.R
import com.example.mypohangapp.model.Category
import com.example.mypohangapp.ui.theme.MyPohangAppTheme


enum class PohangScreen(@StringRes val title: Int) {
    Category(title = R.string.category),
    Recommend(title = R.string.recommend),
    RecommendDetail(title = R.string.recommend_detail)
}

@Composable
fun MyPohangApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = PohangScreen.valueOf(
        backStackEntry?.destination?.route ?: PohangScreen.Category.name
    )

    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryUiState by categoryViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            MyPohangTopAppBar()
        },
        modifier = modifier
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = PohangScreen.Category.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PohangScreen.Category.name) {
                CategoryScreen(
                    categoryList = categoryUiState.categories,
                    modifier = Modifier.fillMaxWidth(),
                    onCategoryClick = {
                        categoryViewModel.selectCategory(it)
                    }
                )
            }
            composable(route = PohangScreen.Recommend.name) {
                RecommendListScreen()
            }
        }
    }
}

@Composable
private fun CategoryScreen(
    modifier: Modifier = Modifier,
    categoryList: List<Category>,
    onCategoryClick: (Category) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(categoryList) { category ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clickable {
                        onCategoryClick(category)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = category.iconId),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    stringResource(id = category.categoryName),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyPohangTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MyPohangAppPreview() {
    MyPohangAppTheme {
        MyPohangApp()
    }
}