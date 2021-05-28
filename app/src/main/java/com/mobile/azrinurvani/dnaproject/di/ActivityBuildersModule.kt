package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity
}