package com.example.refresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BaseRefreshManager {
    protected LayoutInflater mLayoutInflater;
    public BaseRefreshManager(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }
    public abstract View getHeaderView();
    public abstract void downRefresh();
    public abstract void reveraseRefresh();

    public abstract void staticRefresh();

    public abstract void reveraseing();

    public  abstract void MeiTuanDownPercent(float percent);
}
