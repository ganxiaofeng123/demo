package com.example.mysplash.Fragment.design;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class BottomShowBehavior extends CoordinatorLayout.Behavior<TextView> {
    public BottomShowBehavior(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    //即将发生嵌套滚动时回调，axes用于判断滑动方向
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
    //发生嵌套滚动时回调
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
        //向下滑动
        if(dyConsumed +dyUnconsumed >0){
            //隐藏child
            if (child.getVisibility() == View.VISIBLE)
                ShowBottom.hide(child);
        //向上滑动
        }else{
            if (child.getVisibility() != View.VISIBLE)
                ShowBottom.show(child);
        }
    }
}
