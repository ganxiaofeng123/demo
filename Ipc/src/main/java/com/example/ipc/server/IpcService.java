package com.example.ipc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.example.ipc.IResultInterface;
import com.example.ipc.IServiceAidlInterface;

public class IpcService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IServiceAidlInterface.Stub() {
            public IResultInterface resultInterface;
            //异步任务方法
            @Override
            public void excuteAsync(String requestKey, String request) throws RemoteException {
                switch (requestKey){
                    case "shanghai_detail":
                        if(resultInterface != null){
                            resultInterface.callBack(requestKey,"异步远方数据来了");
                        }
                        break;
                    default:
                        break;
                }
            }
            //同步任务
            @Override
            public String excuteSync(String requestKey, String request) throws RemoteException {
                String result = "";
                switch (requestKey){
                    case "shanghai_detail":
                        result = "同步远方数据来了";
                        break;
                    default:
                        break;
                }
                return result;
            }

            @Override
            public void addCallBack(IResultInterface iresultInterface) throws RemoteException {
                //注册aidl
                this.resultInterface = iresultInterface;
            }
        };
    }
}
