package com.example.mysplash.Adapter.hangzhou;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mysplash.Fragment.JiKe.JiKeFragment;
import com.example.mysplash.Fragment.ZhuHu.ZhuHuFragment;
import com.example.mysplash.Fragment.refresh.RefreshFragment;

import java.util.ArrayList;

public class HangZhouViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> list = new ArrayList<>();
    public HangZhouViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        list.add("知乎");
        list.add("即刻");
        list.add("下拉刷新");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ZhuHuFragment();
            case 1:
                return new JiKeFragment();
            case 2:
                return new RefreshFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
