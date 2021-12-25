package net.rhyztech.android.hanasukotonai

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TopicDao @Inject constructor(private val firestore: FirebaseFirestore) {

    fun getTopics() = flow<Topic> {
        val snapshot = firestore.collection("topics").get().await()
        val topics = snapshot.toObjects(Topic::class.java)
        
        topics.forEach {
            Log.i(TAG, it.id + it.titleId)
            emit(it)
        }
    }
}