package com.example.mysplash.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.mysplash.R;
import com.example.mysplash.databinding.ActivityMain2Binding;
import com.example.mysplash.base.BaseActivity;
import com.example.mysplash.main.tools.MainConstantTool;

//@ViewInject(mainidbind = R.layout.activity_main2)
public class MainActivity2 extends BaseActivity<ActivityMain2Binding> implements IMainActivityContarct.iview{

   /* @BindView(R.id.fl_Buttom)
    FloatingActionButton flButtom;
    @BindView(R.id.rl_button_shanghai)
    RadioButton rlButtonShanghai;
    @BindView(R.id.rl_button_hangzhou)
    RadioButton rlButtonHangzhou;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.fl_bottom)
    FrameLayout flBottom;
*/
    private boolean isChange=false;
    private IMainActivityContarct.ipresenter ipresenter = new MainTimerPresenter(this);
    @Override
    protected void afterBindingView() {
        initFragment();
        initListener();
        initCheckListener();
        changeAnime(viewBinding.rgMainBottom,viewBinding.rgMainTab);
    }

    private void initListener() {
        viewBinding.flButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.fl_Buttom:
                        isChange=!isChange;
                        if (isChange){
                            changeAnime(viewBinding.rgMainTab,viewBinding.rgMainBottom);
                            handleTopPosition();
                        }else {
                            changeAnime(viewBinding.rgMainBottom,viewBinding.rgMainTab);
                            handleBottomPosition();
                        }
                        break;
                }
            }
        });
    }
    @Override
    protected ActivityMain2Binding initViewBinding() {
        return ActivityMain2Binding.inflate(LayoutInflater.from(this));
    }
    //左右视图切换
    private void initCheckListener() {
        viewBinding.rlButtonShanghai.setChecked(true);
        viewBinding.rgMainTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == ipresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rl_button_shanghai:
                        ipresenter.replaceFragment(MainConstantTool.SHANGHAI);
                        break;
                    case R.id.rl_button_hangzhou:
                        ipresenter.replaceFragment(MainConstantTool.HANGZHOU);
                        break;
                }
            }
        });

        viewBinding.rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == ipresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rl_button_beijing:
                        ipresenter.replaceFragment(MainConstantTool.BEIJING);
                        break;
                    case R.id.rl_button_shenzhen:
                        ipresenter.replaceFragment(MainConstantTool.SHENZHEN);
                        break;
                }
            }
        });
    }

    //北京 深圳
    private void handleBottomPosition() {
        if (ipresenter.getTopPosition() !=MainConstantTool.HANGZHOU) {
            ipresenter.replaceFragment(MainConstantTool.SHANGHAI);
            viewBinding.rlButtonShanghai.setChecked(true);
        }else{
           ipresenter.replaceFragment(MainConstantTool.HANGZHOU);
           viewBinding.rlButtonHangzhou.setChecked(true);
        }
    }

    //上海 杭州
    private void handleTopPosition() {
        if (ipresenter.getBottomPosition()!=MainConstantTool.SHENZHEN) {
            ipresenter.replaceFragment(MainConstantTool.BEIJING);
            viewBinding.rlButtonBeijing.setChecked(true);
        }else {
           ipresenter.replaceFragment(MainConstantTool.SHENZHEN);
           viewBinding.rlButtonShenzhen.setChecked(true);
        }
    }


    private void initFragment() {
        ipresenter.initFragment();
    }


    private void changeAnime(RadioGroup gone,RadioGroup show) {
        //消失的动画
       gone.clearAnimation();//清楚自身动画
        Animation animationGone=AnimationUtils.loadAnimation(this,R.anim.main_tab_tranlate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);
        //展示的动画
        show.clearAnimation();
        Animation animationShow=AnimationUtils.loadAnimation(this,R.anim.main_tab_tranlate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void ShowFragment(Fragment mfragment) {
        getSupportFragmentManager().beginTransaction().show(mfragment).commit();
    }

    @Override
    public void addFragment(Fragment mfragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_fragment,mfragment).commit();
    }

    @Override
    public void hideFragment(Fragment mfragment) {
        getSupportFragmentManager().beginTransaction().hide(mfragment).commit();
    }
}