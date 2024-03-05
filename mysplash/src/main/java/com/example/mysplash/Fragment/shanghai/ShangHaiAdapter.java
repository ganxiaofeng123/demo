package com.example.mysplash.Fragment.shanghai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysplash.Fragment.shanghai.dto.ShangHaiBean;
import com.example.mysplash.R;

import java.util.ArrayList;
import java.util.List;

public class ShangHaiAdapter extends RecyclerView.Adapter {

    private Context context;
    private final ArrayList<ShangHaiBean> mdata;

    public ShangHaiAdapter(Context context,ArrayList<ShangHaiBean> data) {
        this.context = context;
        mdata = data;
    }

    //创建View,缓冲布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShangHaiBean.IShangHaiItemType.VERTICAL) {
            View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai,parent,false);
            ShanghaiViewHolder shanghaiViewHolder = new ShanghaiViewHolder(inflater);
            return shanghaiViewHolder;
        } else if (viewType == ShangHaiBean.IShangHaiItemType.HORIZANTAL) {
            View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_rv, null);
            ShanghaiViewHolderRv shanghaiViewHolderRv = new ShanghaiViewHolderRv(inflater);
            return shanghaiViewHolderRv;
        }
        return null;
    }

    //绑定ViewHolder
    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShangHaiBean bean = mdata.get(position);
        if (holder instanceof ShanghaiViewHolder){
            ((ShanghaiViewHolder) holder).tv.setText(bean.getMdec());
            ((ShanghaiViewHolder) holder).iv.setVisibility(bean.isShowImg()?View.VISIBLE:View.GONE);

        } else if (holder instanceof ShanghaiViewHolderRv) {
            ((ShanghaiViewHolderRv) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
            ((ShanghaiViewHolderRv) holder).recyclerView.setAdapter(new ShangHaiAdapter(context,bean.getData()));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return mdata.get(position).getmItemType();
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        public final TextView tv;
        public final ImageView iv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_tv);
            iv = itemView.findViewById(R.id.item_shanghai_iv);

        }
    }
    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder{
        public RecyclerView recyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
             recyclerView= itemView.findViewById(R.id.item_recyclerView);
        }
    }
}
