package com.example.mypohangapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mypohangapp.R
import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.Recommend
import com.example.mypohangapp.ui.theme.MyPohangAppTheme

@Composable
fun RecommendDetailScreen(
    modifier: Modifier = Modifier,
    recommend: Recommend?,
    backHandler: () -> Unit
) {
    BackHandler {
        backHandler()
    }

    if (recommend != null) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = recommend.picture),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .testTag(stringResource(R.string.test_tag_detail_picture)),
                contentScale = ContentScale.Crop
            )
            RecommendDetailTextArea(
                recommend = recommend,
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Composable
private fun RecommendDetailTextArea(
    recommend: Recommend,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        Text(
            stringResource(id = recommend.name),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            stringResource(id = recommend.location),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            stringResource(id = recommend.information),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            stringResource(id = recommend.source),
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RecommendDetailPreView() {
    MyPohangAppTheme {
        RecommendDetailScreen(
            recommend = CategoryAndRecommendRepository.recommends[0],
            backHandler = {}
        )
    }
}