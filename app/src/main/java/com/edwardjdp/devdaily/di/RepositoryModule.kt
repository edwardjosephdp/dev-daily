package com.edwardjdp.devdaily.di

import androidx.paging.ExperimentalPagingApi
import com.edwardjdp.devdaily.data.local.LocalDataSource
import com.edwardjdp.devdaily.data.local.LocalDataSourceImpl
import com.edwardjdp.devdaily.data.remote.RemoteDataSource
import com.edwardjdp.devdaily.data.remote.RemoteDataSourceImpl
import com.edwardjdp.devdaily.data.repository.ArticlesRepositoryImpl
import com.edwardjdp.devdaily.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@ExperimentalPagingApi
@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindArticlesRepository(repository: ArticlesRepositoryImpl): ArticlesRepository
}
