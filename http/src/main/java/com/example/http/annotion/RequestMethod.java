package com.example.http.annotion;

import static com.example.http.annotion.RequestMethod.Get;
import static com.example.http.annotion.RequestMethod.Post;

import androidx.annotation.IntDef;

public @interface RequestMethod {
    int Get = 1;
    int Post = 2;
}
