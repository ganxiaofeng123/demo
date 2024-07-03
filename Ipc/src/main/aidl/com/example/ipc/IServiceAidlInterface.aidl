// IServiceAidlInterface.aidl
package com.example.ipc;

// Declare any non-default types here with import statements
import com.example.ipc.IResultInterface;
interface IServiceAidlInterface {
//注意只能识别正常的基础类型
   void excuteAsync(String requestKey,String request);
   String excuteSync(String requestKey,String request);
   void addCallBack(IResultInterface iresultInterface);
}