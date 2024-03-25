package com.example.mysplash.Fragment.hangzhou;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mysplash.Adapter.hangzhou.HangZhouViewPagerAdapter;
import com.example.mysplash.Fragment.ZhuHu.ZhuHuFragment;
import com.example.mysplash.Fragment.shenzhen.ShengZhenFragment;
import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentHangzhouBinding;
import com.example.mysplash.databinding.FragmentZhuhuBinding;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class HangZhouFragment extends BaseFragment<FragmentHangzhouBinding> {
    //Fragment hangzhou = new HangZhouFragment();
    @Override
    protected FragmentHangzhouBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentHangzhouBinding.inflate(inflater,parent,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            //切记不能选择hangzhou,因为杭州带有viewpager会进入无限循环一直调用getItem方法，
            // 导致会创造出很多对象，引出GC(垃圾回收机制),造成内存抖动，甚至内存溢出，软件崩溃。
            //每当适配器需要一个片段并且该片段不存在时，都会调用 getItem。
        getBinding().hangzhouTablayout.setupWithViewPager(getBinding().hangzhouViewPager);
        getBinding().hangzhouViewPager.setAdapter(new HangZhouViewPagerAdapter(getChildFragmentManager()));
        //预加载目的，在进行滑动界面的时候，有网络请求等进行耗时的操作，会让界面更加顺滑，不至于卡顿。
    }
   /* class myHandler extends Handler{

           @Override
           public void handleMessage(@NonNull Message msg) {
               super.handleMessage(msg);*/
               //getBinding().hangzhouTablayout.setupWithViewPager(getBinding().hangzhouViewPager);

               //执行UI的操作






    }


