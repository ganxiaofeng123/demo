package com.example.mysplash.main;

import androidx.fragment.app.Fragment;

import com.example.mysplash.mvp.ILifeCircle;
import com.example.mysplash.mvp.IMvpView;
import com.example.mysplash.mvp.MvpControler;

public interface IMainActivityContarct {
    interface iview extends IMvpView {

        void ShowFragment(Fragment mfragment);

        void addFragment(Fragment mfragment);

        void hideFragment(Fragment fragment);
    }
    interface ipresenter extends ILifeCircle {

        void initFragment();

        int getCurrentCheckedIndex();

        void replaceFragment(int i);

        int getTopPosition();

        int getBottomPosition();

        int getCurrentCheckedId();
    }
    IMainActivityContarct.iview emptyview = new iview() {

        @Override
        public void ShowFragment(Fragment mfragment) {

        }

        @Override
        public void addFragment(Fragment mfragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
