package com.example.task.usecase

import com.example.task.data.repository.Repository
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(private val repository: Repository) {
    fun execute() =
        repository.getPeople()
}