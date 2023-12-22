package com.example.mypohangapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mypohangapp.R
import com.example.mypohangapp.model.Category

@Composable
fun MyPohangPermanentNavigationDrawer(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    selectedCategory: Category?,
    onTabPressed: (Category) -> Unit,
    content: @Composable () -> Unit
) {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(
                modifier = modifier
                    .width(dimensionResource(id = R.dimen.drawer_width))
            ) {
                NavigationDrawerContent(
                    categoryList = categories,
                    selectedDestination = selectedCategory,
                    onTabPressed = onTabPressed
                )
            }
        },
        content = content
    )
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