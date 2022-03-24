package com.example.task.di.module

import com.example.task.di.base.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class BaseModule {
    @Provides
    fun provideActivity() = BaseApplication()
}