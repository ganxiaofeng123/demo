package com.example.http;

import com.example.http.result.IResult;

import java.util.Map;

public class LfHttpServer<T> {
    protected IResult<T> execute(IRequest request, Map<String,Object> params){
        //请求数据入口
        return HttpHelper.execute(request,params);
    }
}
