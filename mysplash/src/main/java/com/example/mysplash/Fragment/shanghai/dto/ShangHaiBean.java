package com.example.mysplash.Fragment.shanghai.dto;

import java.util.ArrayList;

public class ShangHaiBean {
    private  ArrayList<ShangHaiBean> data;
    private String mdec;
    private  boolean isShowImg;
    private int mItemType = IShangHaiItemType.VERTICAL;

    public ArrayList<ShangHaiBean> getData() {
        return data;
    }

    public ShangHaiBean setData(ArrayList<ShangHaiBean> data) {
        this.data = data;
        return this;
    }

    public String getMdec() {
        return mdec;
    }
    //描述
    public ShangHaiBean setMdec(String mdec) {
        this.mdec = mdec;
        return this;
    }

    public  boolean isShowImg() {
        return isShowImg;
    }

    public ShangHaiBean setShowImg(boolean showImg) {
        isShowImg = showImg;
        return this;
    }

    public int getmItemType() {
        return mItemType;
    }

    public ShangHaiBean setmItemType(int mItemType) {
        this.mItemType = mItemType;
        return this;
    }
    public interface IShangHaiItemType{
        int VERTICAL = 0;
        int HORIZANTAL = 1;
    }
}
