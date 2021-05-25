package com.mobile.azrinurvani.dnaproject.di.home

import androidx.lifecycle.ViewModel
import com.mobile.azrinurvani.dnaproject.di.ViewModelKey
import com.mobile.azrinurvani.dnaproject.view.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel
}