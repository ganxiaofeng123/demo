package com.example.mysplash.Fragment.shanghai;

import com.example.mvp.ILifeCircle;
import com.example.mvp.IMvpView;
import com.example.mvp.MvpControler;

//代理
public interface IShangHaiContarct {
    interface iview extends IMvpView {

    }
    interface ipresenter extends ILifeCircle {


        void getNetData();
    }
    IShangHaiContarct.iview emptyview = new IShangHaiContarct.iview() {
        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
