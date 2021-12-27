package net.rhyztech.android.hanasukotonai

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TopicDao @Inject constructor(private val firestore: FirebaseFirestore) {

    suspend fun getTopics(): List<Topic> {
        val snapshot = firestore.collection("topics").get().await()
        return snapshot.toObjects(Topic::class.java)
    }
}