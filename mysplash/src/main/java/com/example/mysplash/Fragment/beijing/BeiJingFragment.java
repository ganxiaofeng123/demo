package com.example.mysplash.Fragment.beijing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mysplash.Fragment.shanghai.Activity.shanghaiDetailActivity;
import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentBeijingBinding;

public class BeiJingFragment extends BaseFragment<FragmentBeijingBinding> {
    @Override
    protected FragmentBeijingBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentBeijingBinding.inflate(inflater,parent,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        getBinding().rlButtonBeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shanghaiDetailActivity.start_5_0(getActivity(),getBinding().rlButtonBeijing);
            }
        });
    }
}
