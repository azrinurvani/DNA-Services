package com.mobile.azrinurvani.dnaproject.di

import androidx.lifecycle.ViewModel
import com.mobile.azrinurvani.dnaproject.di.ViewModelKey
import com.mobile.azrinurvani.dnaproject.view.home.HomeViewModel
import com.mobile.azrinurvani.dnaproject.view.stnk.StnkTahunanViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule{

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StnkTahunanViewModel::class)
    abstract fun bindStnkTahunanViewModel(stnkTahunanViewModel: StnkTahunanViewModel) : ViewModel


}