package com.example.ktorsampleapp.model

import android.util.Log
import com.example.ktorexamplelab.model.Routes
import com.example.ktorsampleapp.model.meme.MemeItem
import com.example.ktorsampleapp.utils.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class MemeApiImp(private val client: HttpClient) : MemeApi {
    override suspend fun getMeme(Link:String): Resource<MemeItem> {
        var route = ""
        return try {
            val response = client.get {
                when(Link){
                    "w" ->route = Routes.WHOLESOME
                    "d" ->route = Routes.DARKSOULS
                    "a" ->route = Routes.ANIMAL
                }
                url(route)
            }
            Resource.Success(response.body())
        } catch (e: RedirectResponseException) {
            Log.e("MemesApi", "3XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: ClientRequestException) {
            Log.e("MemesApi", "4XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: ServerResponseException) {
            Log.e("MemesApi", "5XX Error: ${e.response.status.description}")
            Resource.Error("${e.response}")
        } catch (e: Exception) {
            Log.e("MemesApi", "Error: ${e.message}")
            Resource.Error("${e.message}")
        }
    }
}