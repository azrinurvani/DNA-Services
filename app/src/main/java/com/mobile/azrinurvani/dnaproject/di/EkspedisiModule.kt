package com.mobile.azrinurvani.dnaproject.di

import com.mobile.azrinurvani.dnaproject.view.ekspedisi.adapter.EkspedisiRecyclerAdapter
import com.mobile.azrinurvani.dnaproject.view.stnk.adapter.StnkDetailRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class EkspedisiModule {

    @Provides
    fun provideEkspedisiRecyclerAdapter() : EkspedisiRecyclerAdapter{
        return EkspedisiRecyclerAdapter()
    }
}