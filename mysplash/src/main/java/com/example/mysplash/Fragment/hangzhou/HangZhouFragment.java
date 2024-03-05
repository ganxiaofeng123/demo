package com.example.mysplash.Fragment.hangzhou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentHangzhouBinding;

public class HangZhouFragment extends BaseFragment<FragmentHangzhouBinding> {
    @Override
    protected FragmentHangzhouBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentHangzhouBinding.inflate(inflater,parent,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
