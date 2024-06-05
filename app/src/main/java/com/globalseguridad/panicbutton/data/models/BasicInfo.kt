package com.globalseguridad.panicbutton.data.models


data class BasicInfo(
    val document: String = "",
    val name: String = "",
    val surname: String = "",
    val birthdate: String = "",
    val phone: String = "",
    val email: String = "",
    val photoUrl: String = "",
    val address: String = "",
    val gender: Gender = Gender.OTHER
)
