package com.example.template_android_load_data_from_api.api;

import com.example.template_android_load_data_from_api.models.Issue;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiControllerInterface {

    @GET("/repos/aoancea/dynamic-decorator/issues")
    Call<List<Issue>> listIssues();
}
