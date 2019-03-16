package com.example.template_android_load_data_from_api.api;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.template_android_load_data_from_api.models.Issue;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ApiCall implements IApiCall {

    private static final String LOG_TAG = "ApiCall";

    @Override
    public void listIssues(final CallbackInterface<List<Issue>> callbackInterface) {
        ApiController.getInstance().listIssues().enqueue(new Callback<List<Issue>>() {

            @Override
            public void onResponse(@NonNull Call<List<Issue>> call, @NonNull Response<List<Issue>> response) {
                if (response.isSuccessful()) {
                    Log.d(LOG_TAG, "Successful API call listIssues");

                    List<Issue> issues = response.body();
                    callbackInterface.success(issues);
                } else {
                    Log.e(LOG_TAG, "Failed API call listIssues");
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Issue>> call, @NotNull Throwable t) {
                Log.e(LOG_TAG, "Failed API call listIssues", t);
            }
        });
    }

    public interface CallbackInterface<T> {
        void success(T responseObj);
    }
}

