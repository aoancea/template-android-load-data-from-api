package com.example.template_android_load_data_from_api.models

import com.google.gson.annotations.SerializedName

data class Issue(
    @SerializedName("url") var url: String = "",
    @SerializedName("repository_url") var repository_url: String = "",
    @SerializedName("assignees") var assignees: List<Assignee>?
)

data class Assignee(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("login") var login: String = ""
)