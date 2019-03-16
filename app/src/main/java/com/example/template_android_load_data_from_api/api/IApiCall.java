package com.example.template_android_load_data_from_api.api;

import com.example.template_android_load_data_from_api.models.Issue;

import java.util.List;

public interface IApiCall {

    void listIssues(ApiCall.CallbackInterface<List<Issue>> callbackInterface);
}