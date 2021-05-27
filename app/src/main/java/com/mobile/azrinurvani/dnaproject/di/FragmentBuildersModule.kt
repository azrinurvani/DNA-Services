package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.view.ekspedisi.FragmentDetailEkspedisi
import com.mobile.azrinurvani.dnaproject.view.help.FragmentHelp
import com.mobile.azrinurvani.dnaproject.view.home.FragmentHome
import com.mobile.azrinurvani.dnaproject.view.stnk.FormStnkTahunanFragment
import com.mobile.azrinurvani.dnaproject.view.stnk.FragmentDetailStnk
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFragmentHome() : FragmentHome

    @ContributesAndroidInjector
    abstract fun contributeFragmentStnk() : FragmentDetailStnk

    @ContributesAndroidInjector
    abstract fun contributeFragmentEkspedisi() : FragmentDetailEkspedisi

    @ContributesAndroidInjector
    abstract fun contributeFragmentHelp() : FragmentHelp

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormStnkTahukan() : FormStnkTahunanFragment
}