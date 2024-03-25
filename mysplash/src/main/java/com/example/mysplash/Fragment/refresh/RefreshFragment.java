package com.example.mysplash.Fragment.refresh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mysplash.Adapter.zhihu.ZhiHuAdapter;
import com.example.mysplash.Fragment.MeiTuanRefresh.MeiTuanRefreshManager;
import com.example.mysplash.Fragment.shanghai.IShangHaiContarct;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;
import com.example.mysplash.Fragment.shanghai.shanghaiDetailPresenter;
import com.example.mysplash.R;
import com.example.mysplash.base.BaseFragment;
import com.example.mysplash.databinding.FragmentRefreshBinding;
import com.example.refresh.GodRefreshLayout;

public class RefreshFragment extends BaseFragment<FragmentRefreshBinding> implements IShangHaiContarct.iview {
   /* IShangHaiContarct.ipresenter ipresenter = new shanghaiDetailPresenter(this);
    private ZhiHuAdapter adapter;*/

    @Override
    protected FragmentRefreshBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent) {
        return FragmentRefreshBinding.inflate(inflater,parent,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getBinding().godRefresh.setRefreshManager();
        getBinding().godRefresh.setRefreshManager(new MeiTuanRefreshManager(context));
        initRecyclerView();
        getBinding().godRefresh.RefreshOnLinstener(new GodRefreshLayout.Refresh() {
            @Override
            public void onRefresh() {
                //ipresenter.getNetData(20);
                getBinding().godRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getBinding().godRefresh.refreshOver();
                    }
                },2000);
            }
        });
    }
    private void initRecyclerView() {
        /*ipresenter.getNetData(20);
        getBinding().refreshRecyclerview.setLayoutManager(new LinearLayoutManager(context));*/
    }
    @Override
    public void showData(ShangHaiHttpBean data) {
       /* if (getBinding().refreshRecyclerview.getAdapter() == null){
            adapter = new ZhiHuAdapter(data.result.data);
            getBinding().refreshRecyclerview.setAdapter(adapter);
        }
        getBinding().godRefresh.refreshOver();*/
    }
}
