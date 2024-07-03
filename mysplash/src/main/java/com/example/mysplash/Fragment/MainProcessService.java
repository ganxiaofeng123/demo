package com.example.mysplash.Fragment;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;

import androidx.annotation.Nullable;

public class MainProcessService extends Service {
    private Handler handler = new Handler();
    //跨进程通信的通信的原理
    private Messenger messenger = new Messenger(handler);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
}
