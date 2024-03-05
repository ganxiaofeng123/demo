package com.example.mysplash.main;


import androidx.fragment.app.Fragment;

import com.example.mysplash.Fragment.beijing.BeiJingFragment;
import com.example.mysplash.Fragment.hangzhou.HangZhouFragment;
import com.example.mysplash.Fragment.shanghai.ShangHaiFragment;
import com.example.mysplash.Fragment.shenzhen.ShengZhenFragment;
import com.example.mysplash.R;
import com.example.mysplash.base.BaseMvpPresenter;

/**
 * Created by anson on 2018/11/11.
 */
public class MainTimerPresenter extends BaseMvpPresenter<IMainActivityContarct.iview> implements IMainActivityContarct.ipresenter{

    // 当前Fragment的 角标
    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPosition;
    public MainTimerPresenter(IMainActivityContarct.iview view) {
        super(view);
    }


//    @Override
//    protected IMainActivityContract.Iview getEmptyView() {
//        return IMainActivityContract.emptyView;
//    }

    @Override
    public void initFragment() {
        mCurrentFragmentIndex = 0 ;
        replaceFragment(mCurrentFragmentIndex);
    }

    //切换Fragment的 方法
    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }

        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }

    }


    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
    }


    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }


    // 记录当前 角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.rl_button_shanghai;
                mTopPosition = 0;
                break;
            case 1:
                mCurrentCheckedId = R.id.rl_button_hangzhou;
                mTopPosition = 1;
                break;
            case 2:
                mCurrentCheckedId = R.id.rl_button_beijing;
                mBottomPosition = 2;
                break;
            case 3:
                mCurrentCheckedId = R.id.rl_button_shenzhen;
                mBottomPosition = 3;
                break;
        }
    }

    //创建 当前 Fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShengZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    // 显示 Fragment
    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().ShowFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    // 隐藏Fragment
    private void hideFragment(Fragment mFragment) {
        if (mFragment != null && mFragment.isVisible()) {
            getView().hideFragment(mFragment);
        }
    }

    @Override
    protected IMainActivityContarct.iview getEmptyView() {
        return null;
    }
}
