package com.example.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvp.IMvpView;
import com.example.mvp.MvpControler;

public class LifeCircleMvpFragment extends Fragment implements IMvpView {

    private MvpControler MvpControler;

    @Override
    public MvpControler getMvpControler() {
        if (this.MvpControler==null)
            this.MvpControler = new MvpControler();
        return this.MvpControler;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle == null){
            bundle = new Bundle();
        }
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onCreate(savedInstanceState,null,bundle);
        }
        mvpControler.onActivityCreated(savedInstanceState,null,bundle);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null)
            bundle = new Bundle();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null)
            mvpControler.onActivityCreated(savedInstanceState,null,bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null)
            mvpControler.onViewDestory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onDestory();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onPause();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onSaveInstanceState(bundle);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStop();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityResult(requestCode,resultCode,data);
        }
    }
}
