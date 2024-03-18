package com.example.mysplash.Fragment.shanghai.Module;
import com.example.http.LfHttpServer;
import com.example.http.result.IResult;

import java.util.HashMap;
import java.util.Map;

//构造url
public class ShangHaiDetailHttpTask<T> extends LfHttpServer {
    public IResult<T> getXiaoHuaList(String sort, String page, String pagesize) {
        Map<String, Object> params =new HashMap<>();
        params.put("sort",sort);
        params.put("page",page);
        params.put("pagesize",pagesize);
        params.put("time",""+System.currentTimeMillis()/1000);
        params.put("key","a45a5278641469f539f3412c9b89fda0");
        return super.execute(ShangHaiDetailRequest.xiaohuarequest,params);
    }
}
