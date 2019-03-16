package com.example.template_android_load_data_from_api.Models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName


class BoxOfficeMovieResponse {

    @SerializedName("movies")
    var movies: List<Movie>? = null

    constructor() {
        movies = ArrayList()
    }

    fun parseJSON(response: String): BoxOfficeMovieResponse {
        val gson = GsonBuilder().create()
        return gson.fromJson(response, BoxOfficeMovieResponse::class.java)
    }
}