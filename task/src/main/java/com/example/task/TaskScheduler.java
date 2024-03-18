package com.example.task;


import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.task.tools.ThreadUtil;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {
    //核心线程数量
    private int corePoolSize = ThreadUtil.corePoolSize+1;
    //最大线程数量
    private int maximumPoolSize = corePoolSize*5;
    private final long keepAliveTime = 1;
    //存活单位
    private TimeUnit unit =  TimeUnit.MINUTES;
    private static TaskScheduler instance;
    private final Handler handler;
    interface ITaskScheduler{
        int SUBMIT_Task=1;
    }
    public TaskScheduler(){
        //用于消息调度的线程，主要是主线程发送信息到子线程
        HandlerThread handlerThread = new HandlerThread("handlerThread");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            //运行到子线程
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case ITaskScheduler.SUBMIT_Task:
                        dosubmitTask((AsyncTaskInstance)msg.obj);
                        break;
                }
                return false;
            }
        });

    }
    //创建一个线程池,自定义线程池
    BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>();//无限制队列
    PriorityThreadPoolExecutor executor = new PriorityThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,blockingDeque,new TaskThreadFactory());

    private void dosubmitTask(AsyncTaskInstance asyncTaskInstance) {
        executor.submit(asyncTaskInstance);
    }

    public static TaskScheduler getInstance(){
        if (instance ==null){
            return new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance instance) {
        handler.sendMessage(handler.obtainMessage(ITaskScheduler.SUBMIT_Task,instance));
    }
}
