package com.example.mysplash.Adapter.zhihu;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;
import com.example.mysplash.R;

import java.util.ArrayList;

public class ZhiHuAdapter extends RecyclerView.Adapter {

    private final ArrayList<ShangHaiHttpBean.XiaoHuaBean> mData;

    /**
     * 多个RecyclerView共用一个recycledViewPool对象池，实现内存优化，使UI更加的顺滑
     */

    public ZhiHuAdapter(ArrayList<ShangHaiHttpBean.XiaoHuaBean> data) {
        mData = data;
    }

    //创建View,缓冲布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*if (isHor){
            Log.e("onCreateViewHolder","HORIZANTAL");
        }*/
            View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai,parent,false);
            ShanghaiViewHolder shanghaiViewHolder = new ShanghaiViewHolder(inflater);
            return shanghaiViewHolder;
    }

    //绑定ViewHolder
    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShangHaiHttpBean.XiaoHuaBean bean = mData.get(position);
            ((ShanghaiViewHolder) holder).tv.setText(bean.content);
            ((ShanghaiViewHolder) holder).iv.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;
        public ImageView iv;

        public ShanghaiViewHolder(@NonNull View itemView) {
           super(itemView);
            tv = itemView.findViewById(R.id.item_tv);
            iv = itemView.findViewById(R.id.item_shanghai_iv);
        }
    }

}
