package com.myeducationproject.vkclient.ui.theme.states

import com.myeducationproject.vkclient.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}