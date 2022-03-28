package com.edwardjdp.devdaily.di

import com.edwardjdp.devdaily.domain.usecase.GetLatestArticles
import com.edwardjdp.devdaily.domain.usecase.impl.GetLatestArticlesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetLatestArticles(useCase: GetLatestArticlesImpl): GetLatestArticles
}