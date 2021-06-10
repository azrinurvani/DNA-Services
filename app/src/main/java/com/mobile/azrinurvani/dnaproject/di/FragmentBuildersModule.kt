package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.view.ekspedisi.*
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
    abstract fun contributeFragmentStnk() : FragmentListDetailStnk

    @ContributesAndroidInjector
    abstract fun contributeFragmentDetailListEkspedisi() : FragmentListDetailEkspedisi

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

    @ContributesAndroidInjector
    abstract fun contributeFragmentEkspedisi() : EkspedisiFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormPengirimanMotor() : FormPengirimanMotorFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentFormPengirimanAksesoris() : FormPengirimanBarangFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentDetailPengirimanMotor() : DetailPengirimanMotorFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentDetailPengirimaBarang() : DetailPengirimanBarangFragment

    @ContributesAndroidInjector
    abstract fun contributeFragmentAprovalEkspedisi() : AprovalEkspedisiFragment


}