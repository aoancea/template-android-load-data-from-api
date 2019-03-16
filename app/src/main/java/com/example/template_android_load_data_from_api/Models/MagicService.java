package com.example.template_android_load_data_from_api.Models;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class MagicService {

    public void CallApi() {
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IssuesService serviceProxy = retrofit.create(IssuesService.class);

        serviceProxy.listIssues().enqueue(new Callback<Issue[]>() {
            @Override
            public void onResponse(Call<Issue[]> call, Response<Issue[]> response) {
                // handle response here
                Issue[] issues = response.body();
            }

            @Override
            public void onFailure(Call<Issue[]> call, Throwable t) {

                Throwable temp = t;
            }
        });
    }
}