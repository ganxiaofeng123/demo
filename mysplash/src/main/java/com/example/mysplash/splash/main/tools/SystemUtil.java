package com.example.mysplash.splash.main.tools;

import android.content.Context;

public class SystemUtil {
    public static int dpzpx(Context context,int dpVal){
        // 获取屏幕密度
        final float scale = context.getResources().getDisplayMetrics().density;
        // 结果+0.5是为了int取整时更接近
        return (int) (dpVal * scale + 0.5f);
    }
}
