package com.example.mysplash.Adapter.shanghai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysplash.Fragment.shanghai.Activity.shanghaiDetailActivity;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiBean;
import com.example.mysplash.R;

import java.util.ArrayList;

public class ShangHaiAdapter extends RecyclerView.Adapter {

    private  final Activity mcontext;
    private final ArrayList<ShangHaiBean> mdata;
    private final boolean isHor;
    /**
     * 多个RecyclerView共用一个recycledViewPool对象池，实现内存优化，使UI更加的顺滑
     */
    private final RecyclerView.RecycledViewPool recycledViewPool;

    public ShangHaiAdapter(Activity context, ArrayList<ShangHaiBean> data, boolean isHor) {
        this.mcontext = context;
        mdata = data;
        this.isHor = isHor;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    //创建View,缓冲布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*if (isHor){
            Log.e("onCreateViewHolder","HORIZANTAL");
        }*/
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
            //holder.itemView.setTag(position);

        } else if (holder instanceof ShanghaiViewHolderRv) {
            ((ShanghaiViewHolderRv) holder).recyclerView.setLayoutManager(new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL,false));
            ((ShanghaiViewHolderRv) holder).recyclerView.setAdapter(new ShangHaiAdapter(mcontext,bean.getData(),true));
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

        public TextView tv;
        public ImageView iv;

        public ShanghaiViewHolder(@NonNull View itemView) {
           super(itemView);
            tv = itemView.findViewById(R.id.item_tv);
            iv = itemView.findViewById(R.id.item_shanghai_iv);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // int position= (int) v.getTag();
                   // Toast.makeText(mcontext, "我被点击了，position = "+position, Toast.LENGTH_SHORT).show();
                    shanghaiDetailActivity.start_5_0(mcontext,iv);
                }
            });

        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder{
        public RecyclerView recyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            recyclerView= itemView.findViewById(R.id.item_recyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL,false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            recyclerView.setRecycledViewPool(recycledViewPool);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
