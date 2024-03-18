package com.example.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.IMvpView;
import com.example.mvp.MvpControler;

public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {

    private com.example.mvp.MvpControler MvpControler;

    //静态代理的使用
    @Override
    public MvpControler getMvpControler() {
        if (this.MvpControler==null)
            this.MvpControler = new MvpControler();
        return this.MvpControler;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent == null){
            intent = new Intent();
        }
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onCreate(savedInstanceState,intent,null);
        }
        mvpControler.onActivityCreated(savedInstanceState,intent,null);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onDestory();
        }
    }

    @Override
    protected void onPause() {
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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onNewIntent(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStop();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler = this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityResult(requestCode,resultCode,data);
        }
    }

}
