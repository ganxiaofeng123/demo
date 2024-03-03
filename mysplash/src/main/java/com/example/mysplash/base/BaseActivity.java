package com.example.mysplash.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.example.mysplash.mvp.view.LifeCircleMvpActivity;

public abstract class BaseActivity<VB extends ViewBinding> extends LifeCircleMvpActivity {

    protected VB viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = initViewBinding();
        setContentView(viewBinding.getRoot());
        afterBindingView();
    }


    protected abstract VB initViewBinding();
    /* 子类中：后续具体执行业务逻辑的方法 */
    protected  abstract void afterBindingView();
}