package com.example.mysplash.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentShanghaiBinding;

public class ShangHaiFragment extends BaseFragment<FragmentShanghaiBinding> {
    @Override
    protected FragmentShanghaiBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentShanghaiBinding.inflate(inflater, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
