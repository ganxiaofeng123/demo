package com.example.demo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //TextView t = findViewById(R.id.tv_one);
       // t.setText("ggg");
        Button b = findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() { //点击事件
            @Override
            public void onClick(View v) {

                Log.e(TAG,"onClick:");
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() { //长按事件
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG, "onLongClick: " );
                return false;
            }
        });
        b.setOnTouchListener(new View.OnTouchListener() { //触摸事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "onTouch: " +event.getAction());
                return false;
            }
        });
    }
}