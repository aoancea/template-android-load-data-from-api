package com.example.template_android_load_data_from_api.Models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName


class IssueResponse {

    @SerializedName("movies")
    var issues: List<Issue>? = null

    constructor() {
        issues = ArrayList()
    }

    fun parseJSON(response: String): IssueResponse {
        val gson = GsonBuilder().create()
        return gson.fromJson(response, IssueResponse::class.java)
    }
}