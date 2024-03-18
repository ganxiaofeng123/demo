package com.example.mysplash.Fragment.shanghai.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;


import com.example.mysplash.Fragment.shanghai.IShangHaiContarct;
import com.example.mysplash.Fragment.shanghai.shanghaiDetailPresenter;
import com.example.mysplash.base.BaseActivity;
import com.example.mysplash.databinding.ActivityShanghaiDetailBinding;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class shanghaiDetailActivity extends BaseActivity<ActivityShanghaiDetailBinding> implements IShangHaiContarct.iview {
    private static String mActivityOptionsCompat = "shanghaiDetailActivity";
    IShangHaiContarct.ipresenter ipresenter = new shanghaiDetailPresenter(this);
    @Override
    protected ActivityShanghaiDetailBinding initViewBinding() {
        return ActivityShanghaiDetailBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    protected void afterBindingView() {
        initAnima();
        //getOkhttp();
        intGetNetData();
        //iniPostNetData();
    }

//    private void iniPostNetData() {
//        OkHttpClient client = new OkHttpClient();
//        FormBody.Builder builder = new FormBody.Builder();
//        Request request = new Request.Builder().post(builder.build()).url("https://www.baidu.com").build();//建造者设计模式
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                Log.e("initGetData","onFailure"+e);
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                Log.e("initGetData","response = "+response.body().string());
//            }
//        });
//    }

    private void intGetNetData() {
        ipresenter.getNetData();
        //创建对象
        //Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc","1","2");
//        GetXiaoHuaTask task = new GetXiaoHuaTask();
//            task.execute("desc","1","2");
//        OkHttpClient client = new OkHttpClient();
//        //构建请求
//        HttpUrl.Builder httpUrl = HttpUrl.parse("http://v.juhe.cn/joke/content/list.php").newBuilder();
//        httpUrl.addEncodedQueryParameter("sort","desc");
//        httpUrl.addEncodedQueryParameter("page","1");
//        httpUrl.addEncodedQueryParameter("pagesize","2");
//        httpUrl.addEncodedQueryParameter("time", ""+System.currentTimeMillis()/1000);
//        httpUrl.addEncodedQueryParameter("key","............");
//        //构建Request
//        Request request = new Request.Builder().url(httpUrl.build()).get().build();//建造者设计模式
//        //构建Call
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                Log.e("initGetData","onFailure"+e);
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                Log.e("initGetData","response = "+response.body().string());
//            }
//        });

    }
//Get同步请求
    /*private void getOkhttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client =new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.baidu.com")
                            .build();
                    Response response = client.newCall(request).execute();
                    String Data = response.body().string();
                    showData(Data);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showData(final String Data){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //
                viewBinding.okhttpText.setText(Data);
            }
        });
    }*/


    private void initAnima() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //开启转场动画
            ViewCompat.setTransitionName(viewBinding.detailImg,mActivityOptionsCompat);
        }
    }

    public static void start_5_0(Activity activity, View view){
        //判断Android版本是否大于5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Intent intent = new Intent(activity,shanghaiDetailActivity.class);
            /**
             * Pair是一个容器，作用是轻便地对两个对象组成的元素组进行传递
             */
            Pair pair = new Pair(view,mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,pair);
            ActivityCompat.startActivity(activity,intent,optionsCompat.toBundle());
        }
    }
}
