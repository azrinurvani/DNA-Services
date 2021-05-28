package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.view.adapter.StnkDetailRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class StnkModule {

    @Provides
    fun provideStnkDetailListAdapter() : StnkDetailRecyclerAdapter{
        return StnkDetailRecyclerAdapter()
    }
}