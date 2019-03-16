package com.example.template_android_load_data_from_api.Models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface  IssuesService {

    @GET("/repos/aoancea/dynamic-decorator/issues")
    Call<Issue[]> listIssues();
}
