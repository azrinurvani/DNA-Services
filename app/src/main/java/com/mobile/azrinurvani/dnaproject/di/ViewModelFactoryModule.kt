package com.mobile.azrinurvani.dnaproject.di

import androidx.lifecycle.ViewModelProvider
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelProviderFactory(modelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}