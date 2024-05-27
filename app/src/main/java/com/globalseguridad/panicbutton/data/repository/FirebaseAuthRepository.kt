package com.globalseguridad.panicbutton.data.repository

import com.globalseguridad.panicbutton.data.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository : AuthRepository {

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Boolean {
        return runBlocking {
            try {
                auth.signInWithEmailAndPassword(email, password).await()
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Boolean {
        return runBlocking {
            try {
                auth.createUserWithEmailAndPassword(email, password).await()
                true
            } catch (e: Exception) {
                false
            }
        }
    }
}
