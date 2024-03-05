package com.example.mysplash.Fragment.shanghai.dto;

import java.util.ArrayList;

public class shanghaiDataManager {
    /**
     * 获取竖向数据
     * @param len
     */
    private static ArrayList<ShangHaiBean> getVerData(int len){
        ArrayList<ShangHaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShangHaiBean bean = new ShangHaiBean();
            bean.setShowImg(false).setMdec("上海欢迎您");
            data.add(bean);
        }
        return data;
    }

    /**
     * 获取横向数据
     * @param len
     */
    private static ArrayList<ShangHaiBean> getHorData(int len){
        ArrayList<ShangHaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShangHaiBean bean = new ShangHaiBean();
            bean.setShowImg(true).setMdec("上海是魔都");
            data.add(bean);
        }
        return data;
    }
    public static ArrayList<ShangHaiBean> getData(){
        ArrayList<ShangHaiBean> data = new ArrayList<>();
        data.add(new ShangHaiBean().setData(getHorData(10)).setmItemType(ShangHaiBean.IShangHaiItemType.HORIZANTAL));
        data.addAll(getVerData(10));
        return data;
    }
}
