package com.myeducationproject.vkclient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myeducationproject.vkclient.domain.FeedPost
import com.myeducationproject.vkclient.viewmodels.CommentsViewModel

class CommentsViewModelFactory(
    private val feedPost: FeedPost
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentsViewModel::class.java)) {
            return CommentsViewModel(feedPost) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}