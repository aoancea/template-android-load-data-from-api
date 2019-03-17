package com.example.template_android_load_data_from_api.api;

import com.example.template_android_load_data_from_api.models.Issue;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiController {

    private static final String BASE_URL = "https://api.github.com";
    private static final int RETROFIT_CONNECTION_TIMEOUT_SECONDS = 30;

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
        // prepare a logging interceptor
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // create custom client with timeout and logging interceptor
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(RETROFIT_CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(RETROFIT_CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(RETROFIT_CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    Call<List<Issue>> listIssues() {
        return apiControllerInterface.listIssues();
    }
}