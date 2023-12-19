package com.example.mypohangapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mypohangapp.data.CategoryAndRecommendRepository
import com.example.mypohangapp.model.Recommend
import com.example.mypohangapp.ui.theme.MyPohangAppTheme

@Composable
fun RecommendListScreen(
    modifier: Modifier = Modifier,
    recommendList: List<Recommend>,
    onRecommendClick: (Recommend) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(recommendList) { recommend ->
            RecommendListItem(
                recommend = recommend,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onRecommendClick(recommend)
                    }
            )
        }

    }
}

@Composable
private fun RecommendListItem(
    modifier: Modifier = Modifier,
    recommend: Recommend
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = recommend.picture),
            contentDescription = null,
            modifier = Modifier.size(125.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = recommend.name),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RecommendListPreview() {
    MyPohangAppTheme {
        RecommendListScreen(
            recommendList = CategoryAndRecommendRepository.recommends,
            onRecommendClick = {})
    }
}