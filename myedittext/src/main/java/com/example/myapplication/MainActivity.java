package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.btn);
        EditText e = findViewById(R.id.et);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e.getText().toString();
                Log.e("gxf", "输入的内容:" +text );
            }
        });
    }
}