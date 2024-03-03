package com.example.mysplash.splash;

import com.example.mysplash.mvp.ILifeCircle;
import com.example.mysplash.mvp.IMvpView;
import com.example.mysplash.mvp.MvpControler;

public interface ISplashActivityContarct {
    interface iview extends IMvpView {
        void setTimer(String s);
    }
    interface ipresenter extends ILifeCircle {
        void initTimer();
    }
    //防止空指针
    iview emptyview = new iview() {
        @Override
        public void setTimer(String s) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
