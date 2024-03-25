package com.example.mysplash.Fragment.JiKe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentJikeBinding;

public class JiKeFragment extends BaseFragment<FragmentJikeBinding> {
    @Override
    protected FragmentJikeBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentJikeBinding.inflate(inflater,parent,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
