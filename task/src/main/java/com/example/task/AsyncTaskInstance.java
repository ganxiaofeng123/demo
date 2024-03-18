package com.example.task;

import android.media.Session2Command;

import com.example.task.tools.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.xml.transform.Result;

public class AsyncTaskInstance<T> extends FutureTask<T> {//返回传入进来的泛型
    private final ITaskBackground iTaskBackground;
    private final ITaskCallback iTaskCallback;

    public AsyncTaskInstance(ITaskBackground<T> iTaskBackground, ITaskCallback<T> iTaskCallback) {
        super(new Callable<T>() {
            //执行在子线程
            @Override
            public  T call() throws Exception {
                return iTaskBackground.onBackground();
            }
        });
    this.iTaskBackground = iTaskBackground;
    this.iTaskCallback = iTaskCallback;
    }
    //FutureTask执行完后执行
    @Override
    protected void done() {
        if (iTaskBackground!=null){
            onComplete();
        }
    }
    //获取异常
    @Override
    protected void setException(Throwable t) {
        super.setException(t);
        if (iTaskCallback!=null){
            ThreadUtil.postMainThread(new Runnable() {
                @Override
                public void run() {
                    iTaskCallback.onExeception(t);
                }
            });
        }
    }

    //抛出给主线程
    private void onComplete() {
        Object object = null;
        try {
            object = get();
            if (object!=null){
                Object finalObject = object;
                ThreadUtil.postMainThread(new Runnable() {
                    @Override
                    public void run() {
                        iTaskCallback.onComplete(finalObject);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AsyncTaskInstance getInstance(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        return new AsyncTaskInstance(iTaskBackground,iTaskCallback);
    }
}
