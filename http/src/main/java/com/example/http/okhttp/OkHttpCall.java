package com.example.http.okhttp;

import com.example.http.IRequest;
import com.example.http.annotion.request.call.ICall;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class OkHttpCall implements ICall {
    private final IRequest request;
    private Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
        this.request = request;
    }

    @Override
    public IResponse execute() {
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //静态代理封装方法，将okhttp唯一调用response封装成类
        OkHttpResponse okHttpResponse = new OkHttpResponse(response);
        return okHttpResponse;
    }

    @Override
    public IRequest getRequest() {
        return request;
    }

}
