package com.example.http;

import com.example.http.result.IResult;

public interface IResultCallBack<T>{
    void onSuccess(IResult<T> t);
    void onFailure(IResult<T> t);
}
