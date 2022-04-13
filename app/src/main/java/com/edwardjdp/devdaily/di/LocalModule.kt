package com.edwardjdp.devdaily.di

import android.content.Context
import androidx.room.Room
import com.edwardjdp.devdaily.data.local.DevDailyDb
import com.edwardjdp.devdaily.utils.AppConstants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): DevDailyDb = Room.databaseBuilder(
        context,
        DevDailyDb::class.java,
        DATABASE_NAME
    ).build()

/*    @Provides
    @Singleton
    fun provideArticleDao(database: DevDailyDb) = database.articleDao()

    @Provides
    @Singleton
    fun provideArticleRemoteKeysDao(database: DevDailyDb) = database.articleRemoteKeysDao()*/
}
