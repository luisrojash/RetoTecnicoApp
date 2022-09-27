package com.app.lerp.retotecnicoapp.di

import android.content.Context
import android.content.res.Resources
import com.app.lerp.retotecnicoapp.BuildConfig

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideResources(
        @ApplicationContext context: Context
    ): Resources {
        return context.resources
    }


    @Singleton
    @Provides
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL_API
    }

}