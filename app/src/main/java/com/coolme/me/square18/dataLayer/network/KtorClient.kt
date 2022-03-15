package com.coolme.me.square18.dataLayer.network

import android.util.Log
import com.coolme.me.square18.baseURLSho
import com.coolme.me.square18.portSho
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorClient()
{
    val httpClient : HttpClient = HttpClient(Android) {
        this.followRedirects = true
        install(HttpRedirect) {
            checkHttpMethod = false
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                this.encodeDefaults = true
                this.ignoreUnknownKeys = true
                this.prettyPrint = true
                //this.isLenient = true
            })
        }
        install(HttpTimeout) {
            this.socketTimeoutMillis = 40000L
            this.requestTimeoutMillis = 40000L
            this.connectTimeoutMillis = 40000L
        }
        install(Logging){
            this.logger = object : Logger
            {
                override fun log(message: String)
                {
                    Log.i("Network", message)
                }
            }
            this.level = LogLevel.ALL
        }
        defaultRequest {
            this.url {
                this.host = baseURLSho
                this.port = portSho
            }
            this.contentType(ContentType.Application.Json)
            this.accept(ContentType.Application.Json)
        }
    }
}