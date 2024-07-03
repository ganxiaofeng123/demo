// IResultInterface.aidl
package com.example.ipc;

// Declare any non-default types here with import statements

interface IResultInterface {
    void callBack(String requestKey,String result);
}