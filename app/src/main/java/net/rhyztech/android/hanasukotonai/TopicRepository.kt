package net.rhyztech.android.hanasukotonai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopicRepository @Inject constructor(private val topicDao: TopicDao) {

    suspend fun getTopics() = withContext(Dispatchers.IO) { topicDao.getTopics() }

    suspend fun getAnotherTopic(excludeTopic: Topic) =
        getTopics().filter { it.id != excludeTopic.id }.shuffled().first()
}