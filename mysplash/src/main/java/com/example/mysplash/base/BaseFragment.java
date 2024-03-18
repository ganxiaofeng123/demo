package com.example.mysplash.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.mvp.view.LifeCircleMvpFragment;


public  abstract  class BaseFragment<T extends ViewBinding> extends LifeCircleMvpFragment {
        private T binding;
        protected Activity context;

    @Override
    public void onAttach(@NonNull Activity context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // 调用onCreateViewBinding方法获取binding
            binding = onCreateViewBinding(inflater, container);
            return binding.getRoot();
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            // 引用置空处理
            binding = null;
        }

        // 子类使用该方法来使用binding
        public T getBinding() {
            return binding;
        }

        // 由子类去重写
        protected abstract T onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent);
    }

