package com.example.task.di.module

import com.example.task.presentation.detail.PersonDetailFragment
import com.example.task.presentation.main.MainActivity
import com.example.task.presentation.list.PeopleListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun authenticateActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun coinListFragment(): PeopleListFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun personDetailFragment(): PersonDetailFragment
}