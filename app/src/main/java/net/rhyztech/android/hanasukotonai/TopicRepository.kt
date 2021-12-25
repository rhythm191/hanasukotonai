package net.rhyztech.android.hanasukotonai

import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class TopicRepository @Inject constructor(private val topicDao: TopicDao) {

    suspend fun getTopic(): Topic {
        val drop = (0..1).random()
        return topicDao.getTopics().drop(drop).first()
    }

}