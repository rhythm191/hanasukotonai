package net.rhyztech.android.hanasukotonai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopicViewModel @Inject constructor(private val topicRepository: TopicRepository) : ViewModel() {

    private val _topicText: MutableLiveData<String>  = MutableLiveData()
    val topicText: LiveData<String> = _topicText

    fun changeTopic() {
        val newTopic = topicRepository.getTopic()
        _topicText.value = newTopic.titleId
    }
}