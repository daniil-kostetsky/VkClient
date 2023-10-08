package com.myeducationproject.vkclient.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.domain.StatisticItem
import com.myeducationproject.vkclient.ui.theme.states.NewsFeedScreenState

class NewsFeedViewModel : ViewModel() {

    private val initialList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(
                    id = it
                )
            )
        }
    }

    private val initialState = NewsFeedScreenState.Posts(initialList)

    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

    fun updatePostCount(feedPost: FeedPost, newItem: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

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

        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun deleteBySwipe(post: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val modifiedPosts = currentState.posts.toMutableList()
        modifiedPosts.remove(post)
        _screenState.value = NewsFeedScreenState.Posts(modifiedPosts)
    }
}