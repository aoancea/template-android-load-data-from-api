package com.example.template_android_load_data_from_api.models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IssuesService {

    @GET("/repos/aoancea/dynamic-decorator/issues")
    Call<Issue[]> listIssues();
}