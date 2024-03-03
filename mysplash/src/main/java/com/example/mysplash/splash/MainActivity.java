package com.example.mysplash.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;

import com.example.mysplash.main.MainActivity2;
import com.example.mysplash.R;
import com.example.mysplash.databinding.ActivitySplashBinding;
import com.example.mysplash.base.BaseActivity;

import java.io.File;

public class MainActivity extends BaseActivity<ActivitySplashBinding> implements ISplashActivityContarct.iview {
    private ISplashActivityContarct.ipresenter timerPresenter;


    @SuppressLint("MissingInflatedId")

    @Override
    protected ActivitySplashBinding initViewBinding() {
        return ActivitySplashBinding.inflate(LayoutInflater.from(this));
    }
    @Override
    protected void afterBindingView() {
        initTimePresenter();
        initListener();
        initVedio();
    }

    private void initTimePresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }


    private void initVedio() {
        viewBinding.vvPlay.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator+ R.raw.splash));
    }

    private void initListener() {
            viewBinding.tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (viewBinding.tvText.getText() == "跳过"){
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                        finish();}

                }
            });

        //播放视频
        viewBinding.vvPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        //重复播放
        viewBinding.vvPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       timerPresenter.onDestory();
    }

    public void setTimer(String s) {
        viewBinding.tvText.setText(s);
    }


}