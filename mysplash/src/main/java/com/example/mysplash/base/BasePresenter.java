package com.example.mysplash.base;

import com.example.mvp.IMvpView;
import com.example.mvp.base.BaseMvpPresenter;
import com.example.mysplash.Fragment.shanghai.dto.ShangHaiHttpBean;
import com.example.task.TaskHelper;

//集成mvp网络请求，快捷方式
public  abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {
    public BasePresenter(T view) {
        super(view);
    }
    public void submitTask(JHTask<ShangHaiHttpBean> task){
        TaskHelper.submitTask(task,task);
    }
}
