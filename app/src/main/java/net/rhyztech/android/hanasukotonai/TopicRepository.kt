package net.rhyztech.android.hanasukotonai

import javax.inject.Inject

class TopicRepository @Inject constructor(private val topicDao: TopicDao) {

    suspend fun getTopics(): List<Topic> = topicDao.getTopics()
    
    suspend fun getAnotherTopic(excludeTopic: Topic): Topic {
        val topics = getTopics()

        return topics.filter { it.id != excludeTopic.id }.shuffled().first()
    }

}