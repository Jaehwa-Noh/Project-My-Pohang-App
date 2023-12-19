package com.example.mypohangapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mypohangapp.R
import com.example.mypohangapp.ui.theme.MyPohangAppTheme

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            MyPohangTopAppBar()
        },
        modifier = modifier
    ) { innerPadding ->
        Text("Hello", modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPohangTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    MyPohangAppTheme {
        CategoryScreen()
    }
}