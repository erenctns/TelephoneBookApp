package com.example.telephonebookapp.di

import com.example.telephonebookapp.data.datasource.KisilerDataSource
import com.example.telephonebookapp.data.repo.KisilerRepository
import com.example.telephonebookapp.retrofit.ApiUtils
import com.example.telephonebookapp.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSoruce(kdao:KisilerDao):KisilerDataSource{
        return KisilerDataSource(kdao)
    }
    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource):KisilerRepository{
        return KisilerRepository(kds)
    }
    @Provides
    @Singleton
    fun provideKisilerDao():KisilerDao{
        return ApiUtils.getKisilerDao()
    }
}