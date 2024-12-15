package com.example.projectuas.Network

import com.example.projectuas.Film
import retrofit2.Call
import retrofit2.http.*

interface FilmApiService {

    // Get all films
    @GET("films")
    fun getAllFilms(): Call<List<Film>>

    // Get a specific film by ID
    @GET("films/{id}")
    fun getFilmById(@Path("id") id: Int): Call<Film>

    // Add a new film
    @POST("films")
    fun addFilm(@Body newFilm: Film): Call<Film>

    // Update a film
    @PUT("films/{id}")
    fun updateFilm(@Path("id") id: Int, @Body updatedFilm: Film): Call<Film>

    // Delete a film
    @DELETE("films/{id}")
    fun deleteFilm(@Path("id") id: Int): Call<Void>
}
