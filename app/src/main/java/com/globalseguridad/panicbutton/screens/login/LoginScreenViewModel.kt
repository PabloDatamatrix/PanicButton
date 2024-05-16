package com.globalseguridad.panicbutton.screens.login


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globalseguridad.panicbutton.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun singInWithEmailAndPassword(
        email: String, password: String, home: () -> Unit
    ) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("globalSeg", "Logueado")
                        home()
                    } else {
                        Log.d("globalSeg", "Ocurrio un error!${task.result.toString()}")
                    }
                }
        } catch (ex: Exception) {
            Log.d("globalSeg", "Exception: ${ex.message}")
        }
    }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit
    ) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val displayName =
                            task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        home()
                    } else {
                        Log.d("fun Create user", "create User : ${task.result.toString()}")
                    }
                    _loading.value = false
                }

        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
//        val user = mutableMapOf<String, Any>()
//        user["user_id"]= userId.toString()
//        user["display_name"] = displayName.toString()
        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnCompleteListener {
                Log.d("Create user Firestore", "Creado ${it.result.id}")
            }.addOnFailureListener {
                Log.d("Fail Create User", "Ocurrio un error: ${it.message}")
            }
    }
}
