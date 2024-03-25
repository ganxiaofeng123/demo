package com.example.mysplash.Fragment.ZhuHu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mysplash.Adapter.zhihu.ZhiHuAdapter;
import com.example.mysplash.Fragment.shanghai.IShangHaiContarct;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;
import com.example.mysplash.Fragment.shanghai.shanghaiDetailPresenter;
import com.example.mysplash.R;
import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentZhuhuBinding;

public class ZhuHuFragment extends BaseFragment<FragmentZhuhuBinding> implements IShangHaiContarct.iview{
    IShangHaiContarct.ipresenter ipresenter = new shanghaiDetailPresenter(this);
    @Override
    protected FragmentZhuhuBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentZhuhuBinding.inflate(inflater,parent,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();

    }

    private void initRecyclerView() {
        getBinding().zhihuRecyclerview.setLayoutManager(new LinearLayoutManager(context));
        getBinding().zhihuRecyclerview.setAnimation(AnimationUtils.loadAnimation(context, R.anim.zhihu_anim_show));
        ipresenter.getNetData(20);
    }

    @Override
    public void showData(ShangHaiHttpBean data) {
        if (getBinding().zhihuRecyclerview.getAdapter() == null){
            ZhiHuAdapter adapter = new ZhiHuAdapter(data.result.data);
            getBinding().zhihuRecyclerview.setAdapter(adapter);
        }
    }
}
