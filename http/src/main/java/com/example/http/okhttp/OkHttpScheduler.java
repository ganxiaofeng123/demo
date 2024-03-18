package com.example.http.okhttp;

import androidx.annotation.NonNull;

import com.example.http.HttpScheduler;
import com.example.http.IRequest;
import com.example.http.annotion.RequestMethod;
import com.example.http.annotion.request.call.ICall;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpScheduler extends HttpScheduler {
    Request.Builder requestbuilder = new Request.Builder();
     private OkHttpClient client;
    @Override
    public ICall newCall(IRequest request) {
        Map<String,Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        switch (requestMethod){
            case RequestMethod.Get:
                //拼接Get请求中的url host+path
                StringBuilder urlStrBuilder = new StringBuilder(request.getHost().getHost());
                urlStrBuilder.append(request.getPath());
                HttpUrl.Builder urlBuilder =HttpUrl.parse(urlStrBuilder.toString()).newBuilder();
                if (params != null && params.size()>0){
                    Iterator<Map.Entry<String,Object>> iterator = params.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<String,Object> next = iterator.next();
                        // TODO: 2024/3/10 涉及将object转换为String
                        urlBuilder.addEncodedQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                    }
                    requestbuilder.get().url(urlBuilder.build());
                }
                break;
                case RequestMethod.Post:
                    StringBuilder stringBuilder = new StringBuilder(request.getHost().getHost());
                    stringBuilder.append(request.getPath());
                    HttpUrl.Builder httpUrl = HttpUrl.parse(stringBuilder.toString()).newBuilder();
                    if (params!=null && params.size()>0){
                        Iterator<Map.Entry<String,Object>> iterator = params.entrySet().iterator();
                        while (iterator.hasNext()){
                            Map.Entry<String,Object> next = iterator.next();
                            httpUrl.addEncodedQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                        }
                    }
                    requestbuilder.get().url(httpUrl.build());


        }
        Request okHttpRequest = requestbuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        //通过静态代理将真实call封装成类
        OkHttpCall okHttpCall = new OkHttpCall(request,call);
        return okHttpCall;

    }

    private OkHttpClient getClient() {
        if (client==null){
            //配置okhttp DNS解析
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
           /* builder.dns(new Dns() {
                @NonNull
            @Override
            public List<InetAddress> lookup(@NonNull String host) throws UnknownHostException {
                host = "www.juhe.com";
                List<String> ipList = DNS.getIp(host);
                for (int i = 0; i < ipList.size(); i++) {
                    String ip = ipList.get(i);
                    InetAddress byName = InetAddress.getByName(ip);
                }
                return null;
            }
        });*/
            client = new OkHttpClient();
           /* //信任所有证书
            builder.sslSocketFactory(Https.getSSLSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            client = builder.build();*/
            //拦截器的使用,错误重连，重定向问题
           /* builder.addInterceptor(new Interceptor() {
                @NonNull
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request request = chain.request();
                    *//*String type = request.method();
                    if (type=="get"){
                        //可以拿到公共参数，进行统一处理
                        HttpUrl url = request.url();
                    }else if (type=="post"){
                        RequestBody body = request.body();
                        FormBody body1 = (FormBody) body;
                        body1.value(0);
                    }*//*
                    Response response = chain.proceed(request);
                    if (response==null||response.body().string()=="")//封装response返回
                    return response;
                }
            });*/
        }
        return client;
    }
}
