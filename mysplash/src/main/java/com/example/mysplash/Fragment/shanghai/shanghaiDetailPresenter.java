package com.example.mysplash.Fragment.shanghai;

import android.util.Log;

import com.example.http.result.IResult;
import com.example.mysplash.Fragment.shanghai.Module.ShangHaiDetailHttpTask;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;
import com.example.mysplash.base.BasePresenter;
import com.example.mysplash.base.JHTask;
import com.example.task.LfTask;
import com.google.gson.Gson;

public class shanghaiDetailPresenter extends BasePresenter<IShangHaiContarct.iview> implements IShangHaiContarct.ipresenter{
    public shanghaiDetailPresenter(IShangHaiContarct.iview view) {
        super(view);
    }

    @Override
    protected IShangHaiContarct.iview getEmptyView() {
        return IShangHaiContarct.emptyview;
    }

    @Override
    public void getNetData() {
        /*
        架构师的必要条件
        1.合理运用继承关系
        2.合理运用抽象编程
        3.合理运用泛型传递数据
        4.合理运用设计模式
        * */

        submitTask(new JHTask<ShangHaiHttpBean>() {
                       @Override
                       //运行于子线程
                       public IResult<ShangHaiHttpBean> onBackground() {
                           return new ShangHaiDetailHttpTask<ShangHaiHttpBean>().getXiaoHuaList("desc","1","2");
                       }
                //回调到主线程
                //获取请求结果
                       @Override
                       public void onSuccess(IResult<ShangHaiHttpBean> t) {
                           ShangHaiHttpBean data = t.data();
                           Gson gson = new Gson();
                           String s = gson.toJson(data);
                           Log.e("getNetData",s);
                       }
                       //回调到主线程
            //获取请求结果
            });
//运行于子线程
//            @Override
//            public Object onBackground() {
//                IResult desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc","1","2");
//                return null;
//            }
    }


}
