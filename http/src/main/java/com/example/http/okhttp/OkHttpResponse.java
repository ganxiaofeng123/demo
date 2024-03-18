package com.example.http.okhttp;

import com.example.http.response.IResponse;

import java.io.IOException;

import okhttp3.Response;

public class OkHttpResponse implements IResponse {
    private Response response;
    public OkHttpResponse(Response response) {
        this.response = response;
    }

    @Override
    public String getBodyString() {
        try {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
