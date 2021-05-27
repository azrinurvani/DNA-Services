package com.mobile.azrinurvani.dnaproject.di

import android.app.Application
import com.mobile.azrinurvani.dnaproject.model.db.DnaDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDatabaseInstance(application: Application) : DnaDatabase{
        return DnaDatabase.getDatabaseInstance(application)
    }
}