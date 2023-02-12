package com.example.ktorsampleapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@HiltAndroidApp
class katorSampleApplication :Application(){

}