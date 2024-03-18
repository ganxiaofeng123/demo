package com.example.task;

public interface ITaskCallback<T> {
    //请求成功返回的结果
    void onComplete(T o);
    void onExeception(Throwable throwable);
}
