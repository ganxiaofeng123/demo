package com.example.mysplash.base;

import static com.example.http.annotion.RequestMethod.Get;

import com.example.http.IRequest;
import com.example.http.annotion.RequestMethod;
import com.example.http.annotion.request.LfRequest;
import com.example.http.annotion.request.host.HostManager;
import com.example.http.annotion.request.host.IHost;
import com.example.http.parser.DefaultParse;

import java.lang.reflect.Type;

//封装聚合url
public class JHResquest extends LfRequest {
    public static IRequest sentHttp(String path, @RequestMethod int requestMethod, Type type){
        JHResquest jhResquest = new JHResquest();
        jhResquest.path = path;
        jhResquest.host = HostManager.jhost;
        jhResquest.requestMethod = requestMethod;
        jhResquest.type = type;//将解析器，解析结果封装到request
        jhResquest.resultParse = DefaultParse.getInstance();
        return jhResquest;
    }
}
