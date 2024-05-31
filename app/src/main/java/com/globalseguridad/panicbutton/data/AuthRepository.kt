package com.globalseguridad.panicbutton.data

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Boolean
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Boolean
}
