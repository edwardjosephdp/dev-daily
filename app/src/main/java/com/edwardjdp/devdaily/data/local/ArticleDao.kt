package com.edwardjdp.devdaily.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edwardjdp.devdaily.data.model.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles_table")
    fun getLatestArticles(): PagingSource<Int, Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticles(articles: List<Article>)

    @Query("DELETE FROM articles_table")
    suspend fun deleteArticles()
}
