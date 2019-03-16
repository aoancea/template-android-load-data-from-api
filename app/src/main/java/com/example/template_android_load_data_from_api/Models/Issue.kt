package com.example.template_android_load_data_from_api.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Issue {

    @SerializedName("url")
    @Expose
    private var url: String = ""

    @SerializedName("repository_url")
    @Expose
    private var repository_url: String = ""

    @SerializedName("assignees")
    @Expose
    private var assignees: List<Assignee>? = null
}

class Assignee {

    @SerializedName("id")
    @Expose
    private var id: Int = 0

    @SerializedName("login")
    @Expose
    private var login: String = ""
}