package com.edwardjdp.devdaily.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.edwardjdp.devdaily.utils.AppConstants.ARTICLES_REMOTE_KEYS_TABLE

@Entity(tableName = ARTICLES_REMOTE_KEYS_TABLE)
data class ArticleRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val prevPage: Int?,
    val nextPage: Int?
)