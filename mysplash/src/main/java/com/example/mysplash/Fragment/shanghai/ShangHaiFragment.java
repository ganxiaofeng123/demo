package com.example.mysplash.Fragment.shanghai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mysplash.Adapter.shanghai.ShangHaiAdapter;
import com.example.mysplash.Fragment.shanghai.dto.shanghaiDataManager;
import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentShanghaiBinding;
import com.google.android.material.appbar.AppBarLayout;


public class ShangHaiFragment extends BaseFragment<FragmentShanghaiBinding> {



    @Override
    protected FragmentShanghaiBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentShanghaiBinding.inflate(inflater, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initRecyclerview();
    }

    private void initRecyclerview() {
        getBinding().shanghaiRecyclerview.setLayoutManager(new LinearLayoutManager(context));
        getBinding().shanghaiRecyclerview.setAdapter(new ShangHaiAdapter(context, shanghaiDataManager.getData(),false));
    }

    private void initListener() {
        getBinding().shanghaiAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (-verticalOffset<appBarLayout.getMeasuredHeight()/2){
                    getBinding().shanghaiWelcome.setVisibility(View.GONE);
                }else {
                    getBinding().shanghaiWelcome.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    }

