package com.edwardjdp.devdaily.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edwardjdp.devdaily.data.model.ArticleRemoteKeys

@Dao
interface ArticleRemoteKeysDao {

    @Query("SELECT * FROM articles_remote_keys_table WHERE id =:id")
    suspend fun getRemoteKeys(id: Int): ArticleRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<ArticleRemoteKeys>)

    @Query("DELETE FROM articles_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}
