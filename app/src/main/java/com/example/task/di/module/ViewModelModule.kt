package com.example.task.di.module

import androidx.lifecycle.ViewModel
import com.example.task.di.ViewModelKey
import com.example.task.presentation.detail.PersonDetailViewModel
import com.example.task.presentation.main.MainViewModel
import com.example.task.presentation.list.PeopleListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PeopleListViewModel::class)
    abstract fun bindCoinListViewModel(viewModel: PeopleListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonDetailViewModel::class)
    abstract fun bindPersonDetailViewModel(viewModel: PersonDetailViewModel): ViewModel
}