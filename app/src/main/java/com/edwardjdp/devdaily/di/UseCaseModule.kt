package com.edwardjdp.devdaily.di

import com.edwardjdp.devdaily.domain.usecase.GetArticleByIdUseCase
import com.edwardjdp.devdaily.domain.usecase.GetLatestArticlesUseCase
import com.edwardjdp.devdaily.domain.usecase.impl.GetArticleByIdUseCaseImpl
import com.edwardjdp.devdaily.domain.usecase.impl.GetLatestArticlesUseCaseImpl
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
    abstract fun bindGetLatestArticles(useCase: GetLatestArticlesUseCaseImpl): GetLatestArticlesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetArticleDetails(useCase: GetArticleByIdUseCaseImpl): GetArticleByIdUseCase
}
