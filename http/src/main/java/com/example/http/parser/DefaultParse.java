package com.example.http.parser;

import com.example.http.IRequest;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;
import com.example.http.result.Result;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class DefaultParse implements IParse{
    protected static DefaultParse instance;
    private Gson mGson;


    public static IParse getInstance() {
        if (instance==null){
            instance = new DefaultParse();
        }
        return instance;
    }
    //将请求的数据解析为JSON数据
    @Override
    public IResult parseResponse(IRequest request, IResponse response) {
        Type type = request.getType();
        String str = response.getBodyString();
        //用三方库将string转化成javabean
        mGson= new Gson();
         Object object= mGson.fromJson(str,type);
             return Result.success(object);

    }
}
