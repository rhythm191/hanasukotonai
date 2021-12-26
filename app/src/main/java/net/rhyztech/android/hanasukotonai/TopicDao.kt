package net.rhyztech.android.hanasukotonai

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopicDao @Inject constructor(private val firestore: FirebaseFirestore) {

    suspend fun getTopics(): List<Topic> = withContext(Dispatchers.IO) {
        val snapshot = firestore.collection("topics").get().await()
        return@withContext snapshot.toObjects(Topic::class.java)
    }
}