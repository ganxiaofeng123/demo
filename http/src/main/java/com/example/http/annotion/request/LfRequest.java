package com.example.http.annotion.request;

import com.example.http.parser.IParse;
import com.example.http.IRequest;
import com.example.http.annotion.RequestMethod;
import com.example.http.annotion.request.host.IHost;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

import java.lang.reflect.Type;
import java.util.Map;

public class LfRequest implements IRequest{
    protected IHost host;
    @RequestMethod
    protected int requestMethod;
    protected String path;
    private Map<String, Object> params;
    protected static Type type;
    protected IParse resultParse;


    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public IParse getParser() {
        return resultParse;
    }

    @Override
    public Type getType() {
        return type;
    }


    @Override
    public IResult parseResponse(IRequest request, IResponse response) {
        return null;
    }
}
