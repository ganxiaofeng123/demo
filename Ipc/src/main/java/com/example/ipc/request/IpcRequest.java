package com.example.ipc.request;

import androidx.annotation.NonNull;

import com.example.ipc.CallBack;

public class IpcRequest implements IRequest{
    private String requestKey;
    private String mParams;
    private CallBack mCallBack;
    private Long mTime;

    public IpcRequest(@NonNull String requestKey){
        this.requestKey = requestKey;
        mTime = System.currentTimeMillis();
    }
    @Override
    public void setParams(String param) {
        this.mParams = param;
    }

    @Override
    public String getParams() {
        return mParams;
    }

    @Override
    public String getRequestKey() {
        return requestKey;
    }

    @Override
    public void setCallBack(CallBack callBack) {
        this.mCallBack = callBack;
    }
    public CallBack getCallBack(){
        return mCallBack;
    }

    @Override
    public Long getTime() {
        return mTime;
    }

    @Override
    public int compareTo(IRequest o) {
        return (int) (getTime()-o.getTime());
    }
}
