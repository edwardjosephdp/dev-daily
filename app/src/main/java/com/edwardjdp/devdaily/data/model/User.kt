package com.edwardjdp.devdaily.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class User(
    @SerializedName("github_username")
    val githubUsername: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_image")
    val profileImage: String?,
    @SerializedName("profile_image_90")
    val profileImage90: String?,
    @SerializedName("twitter_username")
    val twitterUsername: String?,
    @SerializedName("username")
    val username: String,
    @SerializedName("website_url")
    val websiteUrl: String?
)
