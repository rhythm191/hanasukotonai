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

    private val _topicText: MutableLiveData<Topic> =
        MutableLiveData(Topic("", "topic_about_progress"))
    val topicText: LiveData<Topic> = _topicText

    suspend fun changeTopic() = viewModelScope.launch {
        val newTopic = topicRepository.getTopic()
        _topicText.value = newTopic
    }
}