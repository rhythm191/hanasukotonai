package net.rhyztech.android.hanasukotonai

import javax.inject.Inject

class TopicRepository @Inject constructor() {

    fun getTopic(): Topic {
        val index = (0..1).random()

        return listOf<Topic>(Topic("topic_about_progress"), Topic("topic_about_career"))[index]
    }

}