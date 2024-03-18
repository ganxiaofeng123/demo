package com.example.http;

import com.example.http.annotion.request.call.ICall;
import com.example.http.okhttp.OkHttpScheduler;
import com.example.http.result.IResult;

import java.util.Map;

public class HttpHelper {
    // TODO: 2024/3/8 请求数据具体逻辑
    private volatile static HttpScheduler httpScheduler;
    protected static <T>IResult<T> execute(IRequest request, Map<String, Object> params){
        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        return getHttpScheduler().execute(call);
    }
    //一个线程访问一个对象中的synchronized(this)同步代码块时，其它线程试图访问该对象的线程将被阻塞。
    private static HttpScheduler getHttpScheduler() {
        if (httpScheduler==null){
            synchronized (HttpHelper.class){
                if (httpScheduler==null){
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }


}
