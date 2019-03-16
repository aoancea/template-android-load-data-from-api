package com.example.template_android_load_data_from_api.Models

class Movie {
    private var id: String = ""
    private var title: String = ""
    private var year: Int = 0

    fun getId(): String {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    fun getYear(): Int {
        return year
    }
}