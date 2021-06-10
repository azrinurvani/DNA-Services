package com.mobile.azrinurvani.dnaproject.di

import android.app.Application
import com.mobile.azrinurvani.dnaproject.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        FragmentBuildersModule::class,
        ViewModelFactoryModule::class,
        AppModule::class,
        ViewModelsModule::class,
        StnkModule::class,
        EkspedisiModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application : Application): Builder

        fun build(): AppComponent
    }
}