package com.myeducationproject.vkclient.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myeducationproject.vkclient.MainViewModel
import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.domain.PostComment

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(viewModel: MainViewModel, paddingValues: PaddingValues) {

    val models = viewModel.models.observeAsState(listOf())
    if (models.value.isNotEmpty()) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(20) {
                add(PostComment(id = it))
            }
        }
        CommentsScreen(feedPost = models.value.get(0), comments = comments)
    }

    
//
//    LazyColumn(
//        modifier = Modifier.padding(paddingValues),
//        contentPadding = PaddingValues(
//            top = 16.dp,
//            start = 8.dp,
//            end = 8.dp,
//            bottom = 72.dp
//        ),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(models.value, key = { it.id }) { post ->
//            val dismissState = rememberDismissState()
//            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
//                viewModel.deleteBySwipe(post)
//            }
//
//            SwipeToDismiss(
//                modifier = Modifier.animateItemPlacement(),
//                state = dismissState,
//                directions = setOf(DismissDirection.EndToStart),
//                background = {}
//            ) {
//                PostCard(
//                    feedPost = post,
//                    onLikeClickListener = { statisticItem ->
//                        viewModel.updatePostCount(post, statisticItem)
//                    },
//                    onCommentClickListener = { statisticItem ->
//                        viewModel.updatePostCount(post, statisticItem)
//                    },
//                    onShareClickListener = { statisticItem ->
//                        viewModel.updatePostCount(post, statisticItem)
//                    },
//                    onViewsClickListener = { statisticItem ->
//                        viewModel.updatePostCount(post, statisticItem)
//                    }
//                )
//            }
//        }
//    }
}