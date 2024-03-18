package com.example.http;

import com.example.http.annotion.request.host.IHost;
import com.example.http.parser.IParse;

import java.lang.reflect.Type;
import java.util.Map;

public interface IRequest extends IParse {

    void setParams(Map<String, Object> params);

    Map<String, Object> getParams();

    int getRequestMethod();

    IHost getHost();

    String getPath();
    IParse getParser();
    Type getType();
}
