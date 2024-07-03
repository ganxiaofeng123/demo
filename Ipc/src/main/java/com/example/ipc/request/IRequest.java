package com.example.ipc.request;

import com.example.ipc.CallBack;

public interface IRequest extends Comparable<IRequest>{
    void setParams(String param);
    String getParams();
    String getRequestKey();

    void setCallBack(CallBack callBack);
    CallBack getCallBack();

    Long getTime();
}
