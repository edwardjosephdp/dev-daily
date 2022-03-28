package com.edwardjdp.devdaily.utils

object AppConstants {
    const val BASE_URL = "https://dev.to/api/"
    const val ARTICLES_ENDPOINT = "articles/latest"
    const val ARTICLE_BY_ID_ENDPOINT = "articles/{id}"

    const val DATABASE_NAME = "devdaily_db"
    const val ARTICLES_TABLE = "articles_table"
    const val ARTICLES_REMOTE_KEYS_TABLE = "articles_remote_keys_table"

    object Parameters {
        const val PAGE = 1
        const val PER_PAGE = 15
    }
}