package com.example.projectuas.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://ppapb-a-api.vercel.app/pi9Id/"

    val api: FilmApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://ppapb-a-api.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FilmApiService::class.java)
    }
}
