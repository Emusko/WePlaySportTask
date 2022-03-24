package com.example.task.data.service.model

import java.io.Serializable

data class Person(
    val name: String,
    val position: String,
    val office: String,
    val email: String,
    val phoneNumber: String
): Serializable