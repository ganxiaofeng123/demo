package com.example.mysplash.manager;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mysplash.Fragment.shanghai.Module.ShangHaiDetailHttpTask;

import java.io.IOException;

import okhttp3.Response;

public class GetXiaoHuaTask extends AsyncTask{
    //运行在子线程中
    @Override
    protected Object doInBackground(Object...objects) {
        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList((String) objects[0],(String) objects[1], (String) objects[2]);
        return desc;
    }
    //运行在主线程中，用于更新UI
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Response response = (Response) o;
        try {
            Log.e("GetXiaoHuaTask","response = "+response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
