package com.example.template_android_load_data_from_api.Models

class Issue {
    private var url: String = ""
    private var repository_url: String = ""

    fun getUrl(): String {
        return url
    }

    fun getRepositoryUrl(): String? {
        return repository_url
    }
}