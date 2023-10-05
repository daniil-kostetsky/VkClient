package com.myeducationproject.vkclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.domain.StatisticItem

class MainViewModel : ViewModel() {

    private val initialList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(
                id = it
            ))
        }
    }

    private val _models = MutableLiveData<List<FeedPost>>(initialList)
    val models: LiveData<List<FeedPost>> = _models

    fun updatePostCount(post: FeedPost, newItem: StatisticItem) {
        val oldStatistics = post.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == newItem.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val updatedPost = post.copy(statistics = newStatistics)

        val modifiedList = models.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll {
            if (it == post) {
                updatedPost
            } else {
                it
            }
        }
        _models.value = modifiedList
    }

    fun deleteBySwipe(post: FeedPost) {
        val modifiedList = models.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(post)
        _models.value = modifiedList
    }
}