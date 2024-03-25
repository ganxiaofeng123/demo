package com.example.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class GodRefreshLayout extends LinearLayout {

    private Context mContext;
    private BaseRefreshManager mRefreshManager;
    private View view;
    private int meatureHeight;
    private int downY;
    private int moveY;
    private int minMeasure;
    private LayoutParams params;
    private int maxMeasure;
    private RefreshState mCurrentState = RefreshState.STATIC;
    private Refresh refreshLinstener;
    private RecyclerView mRecyclerView;
    private ScrollView mScrollView;
    private int InterceptdownY;
    private int InterceptdownX;

    public GodRefreshLayout(Context context) {
        super(context);
        initView(context);
    }

    public GodRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GodRefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
    }
    //开启下拉刷新,下拉刷新的效果默认
    public void setRefreshManager(){
        mRefreshManager = new DefaultRefreshManager(mContext); //默认下拉刷新的效果
        initHeaderView();
    }
    //开启下拉刷新，使用用户自定义的下拉刷新效果
    public void setRefreshManager(BaseRefreshManager manager){
        mRefreshManager = manager;
        initHeaderView();
    }
    private enum RefreshState{
        //静止状态，下拉刷新状态，释放刷新状态，正在刷新状态
        STATIC,DOWNREFRESH,REVEASEREFRESH,REFRESHING
    }
    //刷新完成
    public void refreshOver(){
        hideHeaderView(getParams());
    }
    //刷新完成后回调接口
    public interface Refresh{
        void onRefresh();
    }
    public void RefreshOnLinstener(Refresh refresh){
        this.refreshLinstener = refresh;
    }
    //方法回调时，获取子View
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View childView = getChildAt(0);
        if (childView instanceof RecyclerView){
            mRecyclerView = (RecyclerView) childView;
        }
        //其他ScrollView等等
        if (childView instanceof ScrollView){
            mScrollView = (ScrollView) childView;
        }
    }
    private  void initHeaderView(){
        setOrientation(VERTICAL);
        view = mRefreshManager.getHeaderView();
        view.measure(0,0);
        meatureHeight = view.getMeasuredHeight();
        minMeasure = -meatureHeight;
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,meatureHeight);
        params.topMargin = minMeasure;
        addView(view,0, params);
        maxMeasure = (int) (meatureHeight*0.3f);
    }
    //触发动画效果隐藏View
    private void hideHeaderView(LayoutParams layoutParams) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(layoutParams.topMargin,minMeasure);
        valueAnimator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            layoutParams.topMargin = animatedValue;
            view.setLayoutParams(layoutParams);
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentState = RefreshState.STATIC;
                handleRefreshState(mCurrentState);
            }
        });
        valueAnimator.setDuration(500);
        valueAnimator.start();
    }
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downY = (int) event.getY();
                return true;
                case MotionEvent.ACTION_MOVE:
                    moveY = (int) event.getY();
                    if (downY == 0){
                        downY = InterceptdownY;
                    }
                    int dy = moveY-downY;
                    if (dy>0){
                        LayoutParams layoutParams = getParams();
                        int topMargin = (int) Math.min(dy/1.8f+minMeasure,maxMeasure);//阻尼效果
                        if (topMargin <= 0){
                            //0~1的过程
                            float percent = ((-minMeasure) - (-topMargin) )*1.0f/(-minMeasure); //图片形成百分比缩放
                            mRefreshManager.MeiTuanDownPercent(percent);
                        }
                        if (topMargin <0 && mCurrentState !=RefreshState.DOWNREFRESH){
                            //下拉刷新的状态
                            mCurrentState = RefreshState.DOWNREFRESH;
                            handleRefreshState(mCurrentState);
                        } else if (topMargin >=0 && mCurrentState !=RefreshState.REVEASEREFRESH) {
                            //释放刷新的状态
                            mCurrentState = RefreshState.REVEASEREFRESH;
                            handleRefreshState(mCurrentState);
                        }
                        layoutParams.topMargin = topMargin;
                        view.setLayoutParams(layoutParams);
                    }
                    return true;
                    case MotionEvent.ACTION_UP:
                        if (handleEvent()){
                            return true;
                        }
                        break;
            default:break;
        }
        return super.onTouchEvent(event);
    }

    private boolean handleEvent() {
        LayoutParams layoutParams = getParams();
        if (mCurrentState == RefreshState.DOWNREFRESH){
            mCurrentState = RefreshState.STATIC;
            handleRefreshState(mCurrentState);
            hideHeaderView(layoutParams);
        }else {
            if(layoutParams.topMargin >0){
                layoutParams.topMargin = 0;
            }
            if(refreshLinstener != null){ //客户端传入监听
                refreshLinstener.onRefresh();
            }
            mCurrentState = RefreshState.REFRESHING;
            handleRefreshState(mCurrentState);
        }
        return layoutParams.topMargin>minMeasure;
    }


    private LayoutParams getParams() {
        return (LayoutParams) view.getLayoutParams();
    }
    //对下拉刷新不同的状态设置值，进行相应的操作
    private void handleRefreshState(RefreshState mCurrentState) {
        switch (mCurrentState){
            case STATIC:
                mRefreshManager.staticRefresh();
                break;
            case DOWNREFRESH:
                mRefreshManager.downRefresh();
                break;
            case REVEASEREFRESH:
                mRefreshManager.reveraseRefresh();
                break;
            case REFRESHING:
                mRefreshManager.reveraseing();
                break;
            default:break;
        }
    }
    //拦截器处理拦截事件操作
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                InterceptdownY = (int) ev.getY();
                InterceptdownX = (int) ev.getX();
                break;
                case MotionEvent.ACTION_MOVE:
                    //确定滑动方向，只有上下滑动才会触发
                    int dy = (int) (ev.getY()-InterceptdownY);
                    int dx = (int) (ev.getX()-InterceptdownX);
                    if(Math.abs(dy) >Math.abs(dx) && dy>0 && handleChildViewisTop()){ //上下滑动
                        return true;
                    }
                    break;
                    case MotionEvent.ACTION_UP:
                        break;
            default:break;

        }
        return super.onInterceptTouchEvent(ev);
    }
    //判断子View是否是滑动到顶端的
    private boolean handleChildViewisTop() {
        if (mRecyclerView !=null){
            return RefreshScrollingUtil.isRecyclerViewToTop(mRecyclerView);
        }
        if (mScrollView != null){
            return RefreshScrollingUtil.isScrollViewOrWebViewToTop(mScrollView);
        }
        return false;
    }

}
