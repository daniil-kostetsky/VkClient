package com.myeducationproject.vkclient.domain

import com.myeducationproject.vkclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.LIKES, count = 123),
        StatisticItem(type = StatisticType.COMMENTS, count = 15),
        StatisticItem(type = StatisticType.SHARES, count = 7),
        StatisticItem(type = StatisticType.VIEWS, count = 256)
    )
)
