package com.example.mysplash.Fragment.shanghai;

import com.example.mvp.ILifeCircle;
import com.example.mvp.IMvpView;
import com.example.mvp.MvpControler;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;

//代理
public interface IShangHaiContarct {
    interface iview extends IMvpView {

        void showData(ShangHaiHttpBean data);
    }
    interface ipresenter extends ILifeCircle {


        void getNetData(int pagesize);
    }
    IShangHaiContarct.iview emptyview = new IShangHaiContarct.iview() {
        @Override
        public void showData(ShangHaiHttpBean data) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
