package com.myeducationproject.vkclient.ui.theme

import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.domain.PostComment

sealed class HomeScreenState {

    object Initial: HomeScreenState()

    data class Posts(val posts: List<FeedPost>) : HomeScreenState()

    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : HomeScreenState()
}