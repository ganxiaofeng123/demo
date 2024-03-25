package com.example.refresh;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class DefaultRefreshManager extends BaseRefreshManager{

    private TextView refresh_text;

    public DefaultRefreshManager(Context mContext) {
        super(mContext);
    }

    @Override
    public View getHeaderView() {
        View view = mLayoutInflater.inflate(R.layout.header_layout,null,false);
        refresh_text = view.findViewById(R.id.header_text);
        return view;
    }

    @Override
    public void downRefresh() {
        refresh_text.setText("下拉刷新");
    }

    @Override
    public void reveraseRefresh() {
        refresh_text.setText("释放刷新");
    }

    @Override
    public void staticRefresh() {
        refresh_text.setText("下拉刷新");
    }

    @Override
    public void reveraseing() {
        refresh_text.setText("正在刷新");
    }

    @Override
    public void MeiTuanDownPercent(float percent) {

    }
}
