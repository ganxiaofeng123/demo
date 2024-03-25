package com.example.mysplash.Fragment.MeiTuanRefresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import com.example.mysplash.R;
import com.example.refresh.BaseRefreshManager;

public class MeiTuanRefreshManager extends BaseRefreshManager {

    private ImageView imageView;

    public MeiTuanRefreshManager(Context context) {
        super(context);
    }

    @Override
    public View getHeaderView() {
        View view = mLayoutInflater.inflate(R.layout.meituan_header_layout,null,false);
        imageView = view.findViewById(R.id.meituan_refresh);
        return view;
    }
    //方法只会回调一次,不做处理
    @Override
    public void downRefresh() {

    }

    @Override
    public void reveraseRefresh() {
        //帧动画实现动画刷新的效果
        imageView.setImageResource(R.drawable.mei_tuan_loading_pre);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
    }

    @Override
    public void staticRefresh() {
        imageView.clearAnimation();
        imageView.setImageResource(R.mipmap.pull_image);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
    }

    @Override
    public void reveraseing() {
        imageView.setImageResource(R.drawable.mei_tuan_refreshing_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
    }

    @Override
    public void MeiTuanDownPercent(float percent) {
        imageView.setScaleX(percent);
        imageView.setScaleY(percent);
    }
}
