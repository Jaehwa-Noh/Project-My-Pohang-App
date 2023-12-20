package com.example.mypohangapp.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
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
import com.example.mypohangapp.ui.utils.MyPohangNavigationType


enum class PohangScreen(@StringRes val title: Int) {
    Category(title = R.string.category),
    Recommend(title = R.string.recommend),
    RecommendDetail(title = R.string.recommend_detail)
}

@Composable
fun MyPohangApp(
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = PohangScreen.valueOf(
        backStackEntry?.destination?.route ?: PohangScreen.Category.name
    )

    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryUiState by categoryViewModel.uiState.collectAsState()

    val recommendListViewModel: RecommendListViewModel = viewModel()
    val recommendListUIState by recommendListViewModel.uiState.collectAsState()

    val recommendDetailViewModel: RecommendDetailViewModel = viewModel()
    val recommendDetailUIState by recommendDetailViewModel.uiState.collectAsState()

    val activity = (LocalContext.current as? Activity)

    val navigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            MyPohangNavigationType.LIST
        }

        WindowWidthSizeClass.Medium -> {
            MyPohangNavigationType.NAVIGATION_RAIL
        }

        WindowWidthSizeClass.Expanded -> {
            MyPohangNavigationType.PERMANENT_NAVIGATION_DRAWER
        }

        else -> {
            MyPohangNavigationType.LIST
        }
    }

    when (navigationType) {
        MyPohangNavigationType.LIST -> {
            Scaffold(
                topBar = {
                    MyPohangTopAppBar(
                        currentTitle = currentScreen.title,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = {
                            when (currentScreen.name) {
                                PohangScreen.Recommend.name -> {
                                    navController.popBackStack(
                                        PohangScreen.Category.name,
                                        inclusive = false
                                    )
                                }

                                PohangScreen.RecommendDetail.name -> {
                                    navController.popBackStack(
                                        PohangScreen.Recommend.name,
                                        inclusive = false
                                    )
                                }

                                else -> {
                                    navController.popBackStack()
                                }
                            }

                        }
                    )
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
                                recommendListViewModel.setSelectedCategory(it)
                                recommendDetailViewModel.clearRecommend()
                                navController.navigate(
                                    PohangScreen.Recommend.name
                                )
                            },
                            backHandler = {
                                activity?.finish()
                            }
                        )
                    }
                    composable(route = PohangScreen.Recommend.name) {
                        RecommendListScreen(
                            recommendList = recommendListUIState.recommends,
                            onRecommendClick = {
                                recommendDetailViewModel.setRecommend(it)
                                navController.navigate(
                                    PohangScreen.RecommendDetail.name
                                )
                            },
                            backHandler = {
                                navController.popBackStack(
                                    PohangScreen.Category.name,
                                    inclusive = false
                                )
                            }
                        )
                    }

                    composable(route = PohangScreen.RecommendDetail.name) {
                        RecommendDetailScreen(
                            recommend = recommendDetailUIState.recommend,
                            backHandler = {
                                navController.popBackStack(
                                    PohangScreen.Recommend.name,
                                    inclusive = false
                                )
                            }
                        )
                    }
                }
            }
        }

        MyPohangNavigationType.NAVIGATION_RAIL -> {
            Row(modifier = modifier.fillMaxSize()) {
                NavigationRail {
                    categoryUiState.categories.forEach { category ->
                        NavigationRailItem(
                            selected = categoryUiState.selectedCategory == category,
                            onClick = {
                                categoryViewModel.selectCategory(category)
                                recommendListViewModel.setSelectedCategory(category)
                                recommendDetailViewModel.clearRecommend()
                                navController.navigate(
                                    PohangScreen.Recommend.name
                                )
                            },
                            icon = {
                                Icon(
                                    painterResource(id = category.iconId),
                                    contentDescription = null
                                )
                            },
                            label = { Text(stringResource(id = category.categoryName)) })
                    }
                }

                if (categoryUiState.selectedCategory != null) {
                    RecommendListScreen(
                        recommendList = recommendListUIState.recommends,
                        onRecommendClick = {
                            recommendDetailViewModel.setRecommend(it)
                            navController.navigate(
                                PohangScreen.RecommendDetail.name
                            )
                        },
                        modifier = Modifier.weight(2f),
                        backHandler = {
                            categoryViewModel.clearCategory()
                            navController.popBackStack(
                                PohangScreen.Category.name,
                                inclusive = false
                            )
                        }
                    )
                }

                NavHost(
                    navController = navController,
                    startDestination = PohangScreen.Category.name,
                    modifier = Modifier
                        .weight(3f)
                ) {

                    composable(route = PohangScreen.Category.name) {
                        Box {
                            BackHandler {
                                activity?.finish()
                            }
                        }
                    }

                    composable(route = PohangScreen.Recommend.name) {
                        Box {
                            BackHandler {
                                categoryViewModel.clearCategory()
                                navController.popBackStack(
                                    PohangScreen.Category.name,
                                    inclusive = false
                                )
                            }
                        }
                    }

                    composable(route = PohangScreen.RecommendDetail.name) {
                        RecommendDetailScreen(
                            recommend = recommendDetailUIState.recommend,
                            modifier = Modifier.weight(3f),
                            backHandler = {
                                navController.popBackStack(
                                    PohangScreen.Recommend.name,
                                    inclusive = false
                                )
                            }
                        )
                    }
                }
            }
        }

        MyPohangNavigationType.PERMANENT_NAVIGATION_DRAWER -> {
            PermanentNavigationDrawer(drawerContent = {
                PermanentDrawerSheet(
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.drawer_width))
                ) {
                    NavigationDrawerContent(
                        categoryList = categoryUiState.categories,
                        selectedDestination = categoryUiState.selectedCategory,
                        onTabPressed = { category ->
                            categoryViewModel.selectCategory(category)
                            recommendListViewModel.setSelectedCategory(category)
                            recommendDetailViewModel.clearRecommend()
                            navController.navigate(
                                PohangScreen.Recommend.name
                            )
                        }
                    )
                }
            }) {
                Row(modifier = modifier.fillMaxSize()) {
                    if (categoryUiState.selectedCategory != null) {
                        RecommendListScreen(
                            recommendList = recommendListUIState.recommends,
                            onRecommendClick = {
                                recommendDetailViewModel.setRecommend(it)
                                navController.navigate(
                                    PohangScreen.RecommendDetail.name
                                )
                            },
                            modifier = Modifier.weight(2f),
                            backHandler = {
                                categoryViewModel.clearCategory()
                                navController.popBackStack(
                                    PohangScreen.Category.name,
                                    inclusive = false
                                )
                            }
                        )
                    }

                    NavHost(
                        navController = navController,
                        startDestination = PohangScreen.Category.name,
                        modifier = Modifier
                            .weight(3f)
                    ) {

                        composable(route = PohangScreen.Category.name) {
                            Box {
                                BackHandler {
                                    activity?.finish()
                                }
                            }

                        }

                        composable(route = PohangScreen.Recommend.name) {
                            Box {
                                BackHandler {
                                    categoryViewModel.clearCategory()
                                    navController.popBackStack(
                                        PohangScreen.Category.name,
                                        inclusive = false
                                    )
                                }
                            }
                        }

                        composable(route = PohangScreen.RecommendDetail.name) {
                            RecommendDetailScreen(
                                recommend = recommendDetailUIState.recommend,
                                modifier = Modifier.weight(3f),
                                backHandler = {
                                    navController.popBackStack(
                                        PohangScreen.Recommend.name,
                                        inclusive = false
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun NavigationDrawerContent(
    categoryList: List<Category>,
    selectedDestination: Category?,
    onTabPressed: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.drawer_header))
        )

        categoryList.forEach { category ->
            NavigationDrawerItem(
                label = { Text(stringResource(id = category.categoryName)) },
                selected = category == selectedDestination,
                onClick = { onTabPressed(category) },
                icon = {
                    Icon(
                        painter = painterResource(id = category.iconId),
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Composable
private fun CategoryScreen(
    modifier: Modifier = Modifier,
    categoryList: List<Category>,
    onCategoryClick: (Category) -> Unit,
    backHandler: () -> Unit
) {
    BackHandler {
        backHandler()
    }

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
private fun MyPohangTopAppBar(
    modifier: Modifier = Modifier,
    currentTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(id = currentTitle)) },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            } else {
                Box {}
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyPohangAppPreview() {
    MyPohangAppTheme {
        MyPohangApp(windowSize = WindowWidthSizeClass.Compact)
    }
}