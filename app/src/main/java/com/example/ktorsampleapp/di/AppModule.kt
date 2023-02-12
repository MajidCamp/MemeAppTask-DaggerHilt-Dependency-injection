package com.example.ktorsampleapp.di

import com.example.ktorsampleapp.model.MemeApi
import com.example.ktorsampleapp.model.MemeApiImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHttpClient():HttpClient{
        val client = HttpClient(Android) {
            //Makes the requests thorow an exception if the http status code is does not start with 2
            expectSuccess = true

            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
            //to map json objects returned from the api to a kotlin data class
            install(ContentNegotiation) {
                json(Json {
                    //ignores json keys we have not included in our data class
                    ignoreUnknownKeys = true
                })
            }
            //a logger to see logging information about every request we make using the client
            install(Logging) {
                level = LogLevel.ALL
            }
        }
        return client
    }

    @Provides
    @Singleton
    fun provideMemeApi(client: HttpClient):MemeApi{
        return  MemeApiImp(client)
    }
}