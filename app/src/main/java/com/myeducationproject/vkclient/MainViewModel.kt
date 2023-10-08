package com.myeducationproject.vkclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.domain.PostComment
import com.myeducationproject.vkclient.domain.StatisticItem
import com.myeducationproject.vkclient.ui.theme.HomeScreenState

class MainViewModel : ViewModel() {

    private val initialComments = mutableListOf<PostComment>().apply {
        repeat(10) {
            add(PostComment(id = it))
        }
    }

    private val initialList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(
                    id = it
                )
            )
        }
    }

    private val initialState = HomeScreenState.Posts(initialList)

    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> = _screenState

    private var savedState: HomeScreenState? = initialState

    fun closeComments() {
        _screenState.value = savedState
    }

    fun showComments(feedPost: FeedPost) {
        savedState = screenState.value
        _screenState.value = HomeScreenState.Comments(
            feedPost = feedPost,
            comments = initialComments
        )
    }

    fun updatePostCount(feedPost: FeedPost, newItem: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == newItem.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)

        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }

        _screenState.value = HomeScreenState.Posts(posts = newPosts)
    }

    fun deleteBySwipe(post: FeedPost) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts) return

        val modifiedPosts = currentState.posts.toMutableList()
        modifiedPosts.remove(post)
        _screenState.value = HomeScreenState.Posts(modifiedPosts)
    }
}