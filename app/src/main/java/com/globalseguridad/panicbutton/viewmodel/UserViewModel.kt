package com.globalseguridad.panicbutton.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.globalseguridad.panicbutton.data.models.Gender
import com.globalseguridad.panicbutton.data.models.Photos
import com.globalseguridad.panicbutton.data.models.User

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        val sampleUsers = listOf(
            User(
                id = "1",
                name = "John",
                surname = "Doe",
                email = "john.doe@example.com",
                password = "password123",
                phone = "123456789",
                birthdate = "1990-01-01",
                gender = Gender.MALE,
                document = "ID123456",
                verificationCode = "ABC123",
                photo = Photos(id = "1", path = "/images/user1.jpg"),
                status = "active",
                userId = "user1",
                displayName = "John Doe",
                avatarUrl = "https://example.com/avatar1.jpg"
            ),
            User(
                id = "2",
                name = "Jane",
                surname = "Doe",
                email = "jane.doe@example.com",
                password = "password123",
                phone = "987654321",
                birthdate = "1992-02-02",
                gender = Gender.FEMALE,
                document = "ID654321",
                verificationCode = "XYZ789",
                photo = Photos(id = "2", path = "/images/user2.jpg"),
                status = "inactive",
                userId = "user2",
                displayName = "Jane Doe",
                avatarUrl = "https://example.com/avatar2.jpg"
            )
            // Agrega más usuarios si es necesario
        )
        _users.value = sampleUsers
    }
}
