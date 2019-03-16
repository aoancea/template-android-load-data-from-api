package com.example.template_android_load_data_from_api.api;

import android.support.annotation.NonNull;
import com.example.template_android_load_data_from_api.models.Issue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ApiCall implements IApiCall {

    @Override
    public void listIssues(final CallbackInterface<List<Issue>> callbackInterface) {
        ApiController.getInstance().listIssues().enqueue(new Callback<List<Issue>>() {

            @Override
            public void onResponse(@NonNull Call<List<Issue>> call, @NonNull Response<List<Issue>> response) {

                List<Issue> issues = response.body();

                callbackInterface.success(issues);
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {

            }
        });
    }

    public interface CallbackInterface<T> {
        void success(T responseObj);
    }
}

