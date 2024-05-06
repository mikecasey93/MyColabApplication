package com.example.mycolabapplication.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val converter = GsonConverterFactory.create()
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retroFit = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converter)
        .build()

    // Create reference to our local API endpoints
    val apiClient: ApiEndpoints = retroFit.create(ApiEndpoints::class.java)
}