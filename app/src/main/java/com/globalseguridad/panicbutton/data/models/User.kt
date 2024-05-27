package com.globalseguridad.panicbutton.data.models

data class User(
    val id: String?,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "userId" to this.userId,
            "displayName" to this.displayName,
            "avatarUrl" to this.avatarUrl
        )
    }
}
