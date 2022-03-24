package com.example.task.data.repository

import com.example.task.data.service.ApiServices
import com.example.task.data.service.model.People
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiServices: ApiServices
) {
    fun getPeople() =
        People.peopleList
}