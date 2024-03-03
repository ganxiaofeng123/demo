package com.example.mysplash.splash;

import android.os.Handler;

//1、时时去回调 这个时候是什么时间 倒计时到几秒  观察者设计模式
//2、支持动态传入总时间
//3、每过一秒 总秒数减一
//4、总时间倒计时为0时，要回调完成的状态
public class Splash implements Runnable{
    private  Handler handler;
    private    int time;
    private ICountDownHandler countDownHandler;
    public int countDowntime;
    public boolean isRun;
    //构造方法
    public Splash(int time, ICountDownHandler countDownHandlder){
        handler = new Handler();
        this.time=time;
        this.countDowntime=time;
        this.countDownHandler=countDownHandlder;
    }

    @Override
    public void run() {
        if (isRun){
            if (countDownHandler!=null){
                countDownHandler.onTimer(countDowntime);
            }
            if (countDowntime==0){
                if(countDownHandler!=null){
                    cancel();
                    countDownHandler.onFinish();
                }
            }else {
                countDowntime=time--;
                handler.postDelayed(this,1000);
            }
        }
    }
    //开启倒计时
    public void start(){
        isRun=true;
        handler.post(this);
    }
    //关闭倒计时
    public void cancel(){
        isRun=false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownHandler{
        void onTimer(int time);
        void onFinish();
    }
}
