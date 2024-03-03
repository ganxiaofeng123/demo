package com.example.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class mytextview extends TextView {
    public mytextview(Context context) {
        super(context);
    }

    public mytextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public mytextview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
