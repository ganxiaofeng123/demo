package com.example.mysplash.Fragment.JiKe;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mysplash.R;
import com.example.mysplash.splash.main.tools.SystemUtil;

public class Like extends View {

    private boolean is_like;
    private Bitmap like;
    private Bitmap un_like;
    private Bitmap like_shinning;
    private Paint paint;
    private int left;
    private int top;
    private float handle = 1.0f;
    private float centerX;
    private float centerY;

    public Like(Context context) {
        this(context,null,0);
        init();
    }

    public Like(Context context, @Nullable AttributeSet attrs) {
        this(context,null,0);
        init();
    }

    public Like(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.JiKeLikeView);
        is_like = attr.getBoolean(R.styleable.JiKeLikeView_is_Like,false);
        attr.recycle();
    }
    public void init(){
        like = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_message_like);
        un_like = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_message_unlike);
        like_shinning = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_message_like_shining);
        paint = new Paint();
    }
    //对控件的测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
         int measureWith = 0;
         int measureHeight = 0;
        int maxWith = like.getWidth() + SystemUtil.dpzpx(getContext(),30);
        int maxHeight = like.getHeight()+SystemUtil.dpzpx(getContext(),20);
        int minWith = like.getWidth() + SystemUtil.dpzpx(getContext(),15);
        int minHeight = like.getHeight() + SystemUtil.dpzpx(getContext(),10);
        //拿到当前测量模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        //用户指定大小
        int withSize = MeasureSpec.getSize(widthMeasureSpec);
        int HeightSize = MeasureSpec.getSize(heightMeasureSpec);
        //拿到背景大小
       int suggestedMinimumHeight = getSuggestedMinimumHeight();
       int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if(mode != MeasureSpec.EXACTLY){
            //测量模式未指定,背景有多大，控件就有多大
            if (suggestedMinimumWidth == 0){
                measureWith = maxWith;
            }else {
                measureWith = Math.min(suggestedMinimumWidth,maxWith);
            }
            if (suggestedMinimumHeight == 0){
                measureHeight = maxHeight;
            }else {
                measureHeight = Math.min(suggestedMinimumHeight,maxHeight);
            }

        }else {
            //测量模式指定 //根据用户定义大小判断
            if (withSize < minWith){
                measureWith = minWith;
            }else {
                measureWith = Math.min(withSize,maxWith);
            }
            if (HeightSize <minHeight){
                measureHeight = minHeight;
            }else {
                measureHeight = Math.min(maxHeight,HeightSize);
            }
        }
        setMeasuredDimension(measureWith, measureHeight);
        getPadding(measureWith,measureHeight);
    }
    public void getPadding(int measureWith,int measureHeight){
        int bitmapwidth = like.getWidth();
        int bitmapheight = like.getHeight();
        left = (measureWith-bitmapwidth)/2;
        top = (measureHeight-bitmapheight)/2;
        centerX = measureWith/2;
        centerY = measureHeight/2;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap handbitmap = is_like?like:un_like;
        canvas.save();
        canvas.scale(handle,handle,centerX,centerY);//从X，Y轴中心点缩放
        canvas.drawBitmap(handbitmap,left,top,paint);
        canvas.restore();
        if(is_like){
            canvas.drawBitmap(like_shinning,left+10,0,paint);
        }
        //invalidate();//重绘画布,重新回调onDraw方法
    }
    //销毁自定义视图
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        like.recycle();
        un_like.recycle();
        like_shinning.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                onClick();
                break;
            default:break;
        }
        return super.onTouchEvent(event);
    }

    // TODO: 2024/3/21 待完善动画界面
    private void onClick() {
        is_like = !is_like;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"handleAnim",1.0f,0.8f,1.0f);
        objectAnimator.setDuration(250);
        objectAnimator.start();
    }
    @SuppressLint("ObjectAnimatorBinding")
    public void setHandleAnim(float value){
        this.handle = value;
        invalidate();//重新回调onDraw方法
    }


}
