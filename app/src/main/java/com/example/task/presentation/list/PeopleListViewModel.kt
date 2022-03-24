package com.example.task.presentation.list

import androidx.lifecycle.MutableLiveData
import com.example.task.data.service.model.Person
import com.example.task.di.base.BaseViewModel
import com.example.task.usecase.GetPeopleUseCase
import javax.inject.Inject

class PeopleListViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase
) : BaseViewModel() {
    val peopleLiveData = MutableLiveData<ArrayList<Person>>()
    fun getPeople() {
        peopleLiveData.postValue(getPeopleUseCase.execute())
    }
}