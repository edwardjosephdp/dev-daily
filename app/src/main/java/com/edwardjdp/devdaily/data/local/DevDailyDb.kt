package com.edwardjdp.devdaily.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleRemoteKeys

@Database(entities = [Article::class, ArticleRemoteKeys::class], version = 1)
abstract class DevDailyDb : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun articleRemoteKeysDao(): ArticleRemoteKeysDao

}