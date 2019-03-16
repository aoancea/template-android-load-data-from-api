package com.example.template_android_load_data_from_api.api;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.example.template_android_load_data_from_api.models.Issue;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class ApiController {

    private static ApiController apiController = null;
    private static ApiControllerInterface apiControllerInterface = null;

    public static ApiController getInstance() {
        if (apiController == null || apiControllerInterface == null) {
            apiController = new ApiController();

            apiControllerInterface = getRetrofitClient().create(ApiControllerInterface.class);
        }

        return apiController;
    }

    private static Retrofit getRetrofitClient() {

        OkHttpClient okHttpClient = new OkHttpClient();

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    Call<List<Issue>> listIssues() {
        return apiControllerInterface.listIssues();
    }
}