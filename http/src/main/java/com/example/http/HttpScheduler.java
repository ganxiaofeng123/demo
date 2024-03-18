package com.example.http;

import com.example.http.annotion.request.call.ICall;
import com.example.http.parser.IParse;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public IResult execute(ICall call) {
        IResponse response = call.execute();
        IRequest request = call.getRequest();
        //将拿到的字符串返回值转换为IResult
         IParse parser = request.getParser();
         //封装解析字符串的解析器
        return parser.parseResponse(request,response);
    }
}
