package com.edwardjdp.devdaily.di

import com.edwardjdp.common.Mapper
import com.edwardjdp.devdaily.data.mapper.ApiToDomainArticleMapper
import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.domain.model.ArticleUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperUseCase {

    @Binds
    abstract fun bindsArticlesMapper(mapper : ApiToDomainArticleMapper) : Mapper<Article, ArticleUI>
}