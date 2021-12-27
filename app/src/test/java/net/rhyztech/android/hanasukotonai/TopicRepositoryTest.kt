package net.rhyztech.android.hanasukotonai

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TopicRepositoryTest {

    @Mock
    private lateinit var mockTopicDao: TopicDao

    private val expectedList = listOf(
        Topic("a", "topic_about_progress"),
        Topic("b", "topic_about_career")
    )
    private lateinit var repository: TopicRepository

    @Before
    fun before() = runBlocking {
        `when`(mockTopicDao.getTopics()).thenReturn(expectedList)

        repository = TopicRepository(mockTopicDao)
    }

    @Test
    fun getTopics_return_topic_list() = runBlocking {
        assertEquals(repository.getTopics(), expectedList)
    }


    @Test
    fun getAnotherTopic_return_topic_list() = runBlocking {
        assertEquals(
            repository.getAnotherTopic(expectedList.first()),
            expectedList.last()
        )
    }
}