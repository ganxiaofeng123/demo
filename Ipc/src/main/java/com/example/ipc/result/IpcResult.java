package com.example.ipc.result;

public class IpcResult implements IResult{
    private boolean isSuccess;
    private int code;
    private String data;

    //返回错误的结果
    public static IpcResult getErrorResult(){
        IpcResult result = new IpcResult();
        result.isSuccess= false;
        return result;
    }
    public static IResult getSuccessResult(String data){
        IpcResult result = new IpcResult();
        result.isSuccess = true;
        result.data = data;
        return result;
    }
    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String data() {
        return data;
    }
}
