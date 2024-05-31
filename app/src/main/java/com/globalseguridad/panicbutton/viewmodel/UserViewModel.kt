package com.globalseguridad.panicbutton.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.globalseguridad.panicbutton.data.models.Gender
import com.globalseguridad.panicbutton.data.models.Photos
import com.globalseguridad.panicbutton.data.models.User

class UserViewModel : ViewModel() {
    val users = mutableStateOf<List<User>>(listOf())

    init {
        // Load mock data
        users.value = listOf(
            User(
                id = "1",
                name = "John",
                surname = "Doe",
                email = "john.doe@example.com",
                password = "password",
                phone = "123456789",
                birthdate = "1990-01-01",
                gender = Gender.MALE,
                document = "12345678",
                verificationCode = "code",
                photo = Photos(id = "1", path = "https://c1.klipartz.com/pngpicture/823/765/sticker-png-login-icon-system-administrator-user-user-profile-icon-design-avatar-face-head.png"),
                status = "active",
                userId = "user1",
                displayName = "JohnD",
                avatarUrl = "https://example.com/photo1.jpg"
            ),
            User(
                id = "2",
                name = "Jane",
                surname = "Doe",
                email = "jane.doe@example.com",
                password = "password",
                phone = "987654321",
                birthdate = "1992-02-02",
                gender = Gender.FEMALE,
                document = "87654321",
                verificationCode = "code",
                photo = Photos(id = "2", path = "https://c1.klipartz.com/pngpicture/823/765/sticker-png-login-icon-system-administrator-user-user-profile-icon-design-avatar-face-head.png"),
                status = "active",
                userId = "user2",
                displayName = "JaneD",
                avatarUrl = "https://example.com/photo2.jpg"
            )
        )
    }

    fun getUserById(userId: String): User? {
        return users.value.find { it.userId == userId }
    }
}
