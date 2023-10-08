package com.myeducationproject.vkclient.ui.theme.states

import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>): CommentsScreenState()
}
