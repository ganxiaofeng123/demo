package com.example.mysplash.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public interface ILifeCircle {
    void onCreate(Bundle saveInstanceState, Intent intent,Bundle getArguments);
    void onActivityCreated(Bundle saveInstanceState, Intent intent,Bundle getArguments);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void destoryView();
    void onViewDestory();
    void onNewIntent(Intent intent);
    void onDestory();
    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);
    void onSaveInstanceState(Bundle bundle);
    void attachView(IMvpView iMvpView);

}
