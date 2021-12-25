package net.rhyztech.android.hanasukotonai

import com.google.firebase.firestore.DocumentId

data class Topic(
    @DocumentId
    val id: String = "",
    val titleId: String = ""
)
