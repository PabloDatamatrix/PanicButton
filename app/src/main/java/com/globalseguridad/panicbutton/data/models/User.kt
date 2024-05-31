package com.globalseguridad.panicbutton.data.models

enum class Gender {
    MALE, FEMALE, OTHER
}
data class Photos(
    val id: String?,
    val path: String
){

}

data class User(
    val id: String?,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val phone: String,
    val birthdate: String,
    var gender: Gender,
    val document: String,
    val verificationCode: String,
    val photo:Photos,
    val status:String,

    val userId: String,
    val displayName: String,
    val avatarUrl: String,
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "userId" to this.userId,
            "displayName" to this.displayName,
            "avatarUrl" to this.avatarUrl,
            "id" to (this.id ?: ""),
            "name" to this.name,
            "surname" to this.surname,
            "email" to this.email,
            "password" to this.password,
            "phone" to this.phone,
            "birthdate" to this.birthdate,
            "gender" to this.gender.toString(),
            "document" to this.document,
            "verificationCode" to this.verificationCode,
            "photo" to mapOf(
                "id" to (this.photo.id ?: ""),
                "path" to this.photo.path
            ),
            "status" to this.status
        )
    }
}
