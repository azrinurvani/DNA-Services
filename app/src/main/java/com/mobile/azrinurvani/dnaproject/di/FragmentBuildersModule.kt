package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.view.ekspedisi.FragmentDetailEkspedisi
import com.mobile.azrinurvani.dnaproject.view.help.FragmentHelp
import com.mobile.azrinurvani.dnaproject.view.home.FragmentHome
import com.mobile.azrinurvani.dnaproject.view.stnk.*
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
    abstract fun contributeFragmentFormStnkTahunan() : FormStnkTahunanFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormStnk5Tahunan() : FormStnkLimaTahunanFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormStnkHilang() : FormStnkHilangFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormMutasi() : FormMutasiFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormBalikNama() : FormBalikNamaFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentAprovalStnk() : AprovalStnkFragment
}