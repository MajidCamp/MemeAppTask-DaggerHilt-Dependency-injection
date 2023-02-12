package com.example.ktorsampleapp.model.meme


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemeItem(
    @SerialName("count")
    val count: Int?,
    @SerialName("memes")
    val memes: List<Meme?>?
)