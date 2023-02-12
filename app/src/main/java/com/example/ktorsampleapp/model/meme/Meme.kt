package com.example.ktorsampleapp.model.meme


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meme(
    @SerialName("author")
    val author: String?,
    @SerialName("nsfw")
    val nsfw: Boolean?,
    @SerialName("postLink")
    val postLink: String?,
    @SerialName("preview")
    val preview: List<String?>?,
    @SerialName("spoiler")
    val spoiler: Boolean?,
    @SerialName("subreddit")
    val subreddit: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("ups")
    val ups: Int?,
    @SerialName("url")
    val url: String?
)