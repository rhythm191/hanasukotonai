package net.rhyztech.android.hanasukotonai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicViewModel @Inject constructor(private val topicRepository: TopicRepository) :
    ViewModel() {

    private val defaultTopic = Topic("h4zxbacIgeFiVcwatbVA", "topic_about_progress")

    private val _topic: MutableLiveData<Topic> =
        MutableLiveData(defaultTopic)
    val topic: LiveData<Topic> = _topic

    suspend fun changeTopic() = viewModelScope.launch {
        val newTopic =
            _topic.value?.let { topicRepository.getAnotherTopic(it) }
        _topic.value = newTopic ?: defaultTopic
    }
}