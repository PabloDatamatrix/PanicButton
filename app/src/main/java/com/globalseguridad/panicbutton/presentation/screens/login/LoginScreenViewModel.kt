package com.globalseguridad.panicbutton.presentation.screens.login


import android.util.Log
import androidx.lifecycle.ViewModel
import com.globalseguridad.panicbutton.data.models.Gender
import com.globalseguridad.panicbutton.data.models.Photos
import com.globalseguridad.panicbutton.data.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class LoginScreenViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    // Función para iniciar sesión con correo y contraseña
    fun signInWithEmailAndPassword(
        email: String, password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess()
                } else {
                    onError(task.exception?.message ?: "Unknown error occurred")
                }
            }
    }

    // Función para crear una cuenta con correo y contraseña
    fun createUserWithEmailAndPassword(
        email: String, password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val displayName = task.result?.user?.email?.split("@")?.get(0)
                    createUser(displayName ?: "User")
                    onSuccess()
                } else {
                    onError(task.exception?.message ?: "Unknown error occurred")
                }
            }
    }

    // Función para crear un usuario en Firestore
    private fun createUser(displayName: String) {
        val userId = auth.currentUser?.uid
        val user = User(
            id = null,
            name = "John",
            surname = "Doe",
            email = "john.doe@example.com",
            password = "password123",
            phone = "1234567890",
            birthdate = "1990-01-01",
            gender = Gender.MALE,
            document = "123456789",
            verificationCode = "verificationCode123",
            photo = Photos(
                id = "1",
                path = "path/to/photo.jpg"
            ),
            status = "Active"
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnCompleteListener {
                Log.d("Create user Firestore", "Created ${it.result?.id}")
            }.addOnFailureListener {
                Log.e("Fail Create User", "Error: ${it.message}")
            }
    }
}

//class LoginScreenViewModel : ViewModel() {
//    private val auth: FirebaseAuth = Firebase.auth
//    private val _loading = MutableLiveData(false)
//
//    fun signInWithEmailAndPassword(
//        email: String, password: String, home: () -> Unit
//    ) = viewModelScope.launch {
//        try {
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.d("globalSeg", "Logueado")
//                        home()
//                    } else {
//                        Log.d("globalSeg", "Ocurrio un error!${task.result.toString()}")
//                    }
//                }
//        } catch (ex: Exception) {
//            Log.d("globalSeg", "Exception: ${ex.message}")
//        }
//    }
//
//    fun createUserWithEmailAndPassword(
//        email: String,
//        password: String,
//        home: () -> Unit
//    ) {
//        if (_loading.value == false) {
//            _loading.value = true
//            auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        val displayName =
//                            task.result.user?.email?.split("@")?.get(0)
//                        createUser(displayName)
//                        home()
//                    } else {
//                        Log.d("fun Create user", "create User : ${task.result.toString()}")
//                    }
//                    _loading.value = false
//                }
//
//        }
//    }
//
//    private fun createUser(displayName: String?) {
//        val userId = auth.currentUser?.uid
////        val user = mutableMapOf<String, Any>()
////        user["user_id"]= userId.toString()
////        user["display_name"] = displayName.toString()
//        val user = User(
//            userId = userId.toString(),
//            displayName = displayName.toString(),
//            avatarUrl = "",
//            id = null
//        ).toMap()
//
//        FirebaseFirestore.getInstance().collection("users")
//            .add(user)
//            .addOnCompleteListener {
//                Log.d("Create user Firestore", "Creado ${it.result.id}")
//            }.addOnFailureListener {
//                Log.d("Fail Create User", "Ocurrio un error: ${it.message}")
//            }
//    }
//}
