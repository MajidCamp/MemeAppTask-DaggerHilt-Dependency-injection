package com.example.ktorsampleapp.model

import com.example.ktorsampleapp.model.meme.MemeItem
import com.example.ktorsampleapp.utils.Resource

interface MemeApi {
    suspend fun getMeme(Link:String): Resource<MemeItem>
}