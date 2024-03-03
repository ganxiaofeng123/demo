package com.example.mysplash.splash;

import android.util.Log;

import com.example.mysplash.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContarct.iview> implements ISplashActivityContarct.ipresenter {
    private Splash timer;

    public SplashTimerPresenter(ISplashActivityContarct.iview view) {
        super(view);
    }

    public void initTimer(){
        timer = new Splash(5, new Splash.ICountDownHandler() {
            @Override
            public void onTimer(int time) {
                getView().setTimer(time+"秒");
            }

            @Override
            public void onFinish() {
                getView().setTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }

    @Override
    public void onDestory() {
        super.onDestory();
        cancel();
        Log.e("SplashTimerPresenter","onDestory");
    }

    @Override
    protected ISplashActivityContarct.iview getEmptyView() {
        return null;
    }
}
