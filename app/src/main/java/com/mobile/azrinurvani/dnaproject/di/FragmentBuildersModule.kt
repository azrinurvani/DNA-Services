package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.di.home.HomeViewModelModule
import com.mobile.azrinurvani.dnaproject.view.ekspedisi.FragmentEkspedisi
import com.mobile.azrinurvani.dnaproject.view.help.FragmentHelp
import com.mobile.azrinurvani.dnaproject.view.home.FragmentHome
import com.mobile.azrinurvani.dnaproject.view.stnk.FragmentStnk
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(
        modules = [HomeViewModelModule::class]
    )
    abstract fun contributeFragmentHome() : FragmentHome

    @ContributesAndroidInjector
    abstract fun contributeFragmentStnk() : FragmentStnk

    @ContributesAndroidInjector
    abstract fun contributeFragmentEkspedisi() : FragmentEkspedisi

    @ContributesAndroidInjector
    abstract fun contributeFragmentHelp() : FragmentHelp
}