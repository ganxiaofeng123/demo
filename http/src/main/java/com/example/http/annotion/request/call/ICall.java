package com.example.http.annotion.request.call;

import com.example.http.IRequest;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

public interface ICall {
    IResponse execute();
    IRequest getRequest();
}
